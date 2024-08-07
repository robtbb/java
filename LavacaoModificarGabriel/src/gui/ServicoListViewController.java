package gui;

import application.Main;
import gui.util.Alertas;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.entities.Servico;
import model.entities.enuns.ECategoria;
import model.services.ServicoDeServicoLavacao;

public class ServicoListViewController implements Initializable {

	ServicoDeServicoLavacao servico = new ServicoDeServicoLavacao();
	
	@FXML
	private VBox mainVBox;
	@FXML
	private Button btMenus;
	public void onBtMenusAction(){
		loadViewSemFilhos("/gui/InteracaoMainView.fxml");
	}
	@FXML
	private Label lbRecebeTipo;
	@FXML
	private Label lbRecebeValor;
	@FXML
	private Label lbRecebePontos;
	@FXML
	private Label lbRecebeCategoria;
	@FXML
	private TextField tfPesquisa;
	@FXML
	private ToggleButton btCatPequeno;
	@FXML
	private ToggleButton btCatMedio;
	@FXML
	private ToggleButton btCatGrande;
	@FXML
	private ToggleButton btCatMoto;
	@FXML
	private ToggleButton btCatPadrao;
	@FXML
	private ToggleButton btVoltar;
	@FXML
	private StackPane stackPaneComImage;
	@FXML
	private Label lbIndicaCategoria;
	@FXML
	private TableView<ItensProperty> tbViewOpcoes;
	@FXML
	private TableColumn<ItensProperty, String> tbColumnOpcoes;
	@FXML
	private static final ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		stackPaneComImage.setVisible(true);
		tbViewOpcoes.setVisible(false);
		lbIndicaCategoria.setText("Selecione uma categoria");
		tfPesquisa.setPromptText("Pesquise o serviço...");
		tfPesquisa.setOnAction((ActionEvent t) -> {
			if (tfPesquisa.getText() != null) {
				System.out.println(tfPesquisa.getText());
			}
		});
		tbColumnOpcoes.setCellValueFactory(new PropertyValueFactory<>("servico"));
		List<Servico> servicos = servico.buscaTodos();
		for (Servico serv : servicos) {
			String servic = serv.getDescricao();
			ItensProperty itens = new ItensProperty(servic);
			listItens.add(itens);
		}
		tbViewOpcoes.setItems(listItens);
		initButtonCat();
		addBotoesToggleAoGrupo();
		insertImagem(btMenus, "/resources/img/IconeMenu.png");
	}

	public class ItensProperty {

		private final SimpleStringProperty servico;

		public ItensProperty(String servico) {
			this.servico = new SimpleStringProperty(servico);
		}

		public String getServico() {
			return servico.get();
		}

		public void setServico(String servico) {
			this.servico.set(servico);
		}
	}

	public void updateTableView(String DescCategoria) {
		ObservableList<ItensProperty> listaFiltrada = FXCollections.observableArrayList();
		//	ESTA FUNÇÃO ABAIXO BUSCA O ID DA CATEGORIA ATRAVÉS DE SUA DESCRIÇÃO
		int idCat = ECategoria.findIdByDescricao(DescCategoria);
		// LOGO QUE TENHO O ID DA CATEGORIA FAÇO A BUSCA DOS SERVIÇOES RELACIONADOS A ELA. 
		for (Servico serv : servico.bustaTodosServicoPorIdDaCategoria(idCat)) {
			// TRANSFORMO CADA SERVIÇO( APENAS OS NOMES ) EM ITENS PROPERTY POR PREFERÊNCIA PROPRIA
			ItensProperty itens = new ItensProperty(serv.getDescricao());
			// ADD CADA ITEM NA LISTA ( FILTRADA POR CATEGORIA)
			listaFiltrada.add(itens);
		}
		tbViewOpcoes.setItems(listaFiltrada);

		if (!listaFiltrada.isEmpty()) {
			// Exibe a TableView
			tbViewOpcoes.setVisible(true);
			lbIndicaCategoria.setVisible(false);
		} else {
			// Exibe o Label
			tbViewOpcoes.setVisible(false);
			lbIndicaCategoria.setVisible(true);
		}
	}

	private void apresentaObservacoes(String categoriaString) {
		tbViewOpcoes.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 0) {
				ItensProperty itemSelecionado = tbViewOpcoes.getSelectionModel().getSelectedItem();
				if (itemSelecionado != null) {
					String str = itemSelecionado.getServico();
					Servico servi = servico.buscaServicoPelaDescricaoDaCategoria(str, categoriaString);
					lbRecebeTipo.setText(servi.getDescricao());
					lbRecebeValor.setText(String.format("%.2f", servi.getValor()));
					lbRecebePontos.setText(String.valueOf(servi.getPontos()));
					lbRecebeCategoria.setText((servi.getCategoria().getDescricao()));
				}
			}
		});
	}

	public void mostrarStackPane() {
		stackPaneComImage.setVisible(true);
		tbViewOpcoes.setVisible(false);
	}

	public void mostrarTableView() {
		stackPaneComImage.setVisible(false);
		tbViewOpcoes.setVisible(true);
		tbViewOpcoes.setItems(listItens);
	}

	ToggleGroup grupoDeBotoes = new ToggleGroup();

	public void addBotoesToggleAoGrupo() {
		/*ToggleGroup  é usado para gerenciar o estado dos botões que pertencem a ele. 
	O ToggleGroup serve para agrupar botões de forma que apenas um possa estar selecionado por vez.*/
		btCatPequeno.setToggleGroup(grupoDeBotoes);
		btCatMedio.setToggleGroup(grupoDeBotoes);
		btCatGrande.setToggleGroup(grupoDeBotoes);
		btCatMoto.setToggleGroup(grupoDeBotoes);
		btCatPadrao.setToggleGroup(grupoDeBotoes);
	}

	public void initButtonCat() {
		btCatPequeno.setOnAction(event -> {
			updateTableView("Pequeno");
			tbColumnOpcoes.setText("PEQUENO");
			apresentaObservacoes("Pequeno");
			alteraCorButtonSelecionado();
		});
		btCatMedio.setOnAction(event -> {
			updateTableView("Medio");
			tbColumnOpcoes.setText("MEDIO");
			apresentaObservacoes("Medio");
			alteraCorButtonSelecionado();
		});
		btCatGrande.setOnAction(event -> {
			updateTableView("Grande");
			tbColumnOpcoes.setText("GRANDE");
			apresentaObservacoes("Grande");
			alteraCorButtonSelecionado();
		});
		btCatMoto.setOnAction(event -> {
			updateTableView("Moto");
			tbColumnOpcoes.setText("MOTO");
			apresentaObservacoes("Moto");
			alteraCorButtonSelecionado();
		});
		btCatPadrao.setOnAction(event -> {
			updateTableView("Padrao");
			tbColumnOpcoes.setText("PADRAO");
			apresentaObservacoes("Padrao");
			alteraCorButtonSelecionado();
		});
		btVoltar.setOnAction(event -> {
			grupoDeBotoes.selectToggle(null);
			lbIndicaCategoria.setVisible(true);
			resetaCoresDosBotoes();
			mostrarStackPane();
			
		});
	}

	public void alteraCorButtonSelecionado() {
		for (Toggle button : grupoDeBotoes.getToggles()) {
			ToggleButton toggleButton = (ToggleButton) button;
			if (button == grupoDeBotoes.getSelectedToggle()) {
				toggleButton.setStyle("-fx-background-color: green; -fx-text-fill: white");
			} else {
				toggleButton.setStyle(""); // Reseta a cor dos botões não selecionados
			}
		}
	}

	public void resetaCoresDosBotoes() {
		for (Toggle button : grupoDeBotoes.getToggles()) {
			((ToggleButton) button).setStyle(""); // Reseta a cor dos botões ao voltar
		}
		if (grupoDeBotoes.getSelectedToggle() != null) {
			grupoDeBotoes.selectToggle(null); // retira a seleção dos botões
		}
	}

	public void insertImagem(Button botao, String caminhoDaImagem) {
		URL imageUrl = getClass().getResource(caminhoDaImagem);
		Image imagem = new Image(imageUrl.toExternalForm());
		ImageView imageView = new ImageView(imagem);
		imageView.setFitWidth(20);
		imageView.setFitHeight(55);
		
		// Ajusta propriedades do ImageView
		imageView.setPreserveRatio(true);
		botao.setGraphic(imageView);
	}
	private synchronized void loadViewSemFilhos(String caminhoView) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoView));
			VBox newVBox = loader.load();

			//REFERENCIA DO MAINSCENE PRINCIPAL
			Scene mainScene = Main.getMainScene();
			Node root = mainScene.getRoot();
			mainVBox = (VBox) root;
			mainVBox.getChildren().clear();
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alertas.apresentaAlertas("IO Exception", "Erro ao carregar a View", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
}
