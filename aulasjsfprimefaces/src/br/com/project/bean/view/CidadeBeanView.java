package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.CidadeController;
import br.com.project.model.classes.Cidade;

@Controller
@Scope(value = "session")
@ManagedBean(name = "cidadeBeanView")
public class CidadeBeanView extends BeanManagedViewAbstract {

	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_cidade.jsf?faces-redirect=true";

	private String urlFind = "/cadastro/find_cidade.jsf?faces-redirect=true";

	private Cidade objetoSelecionado = new Cidade();

	private List<Cidade> list = new ArrayList<Cidade>();

	@Resource
	private CidadeController cidadeController;

	@Override
	public String save() throws Exception {
		objetoSelecionado = cidadeController.merge(objetoSelecionado);
		novo();
		return "";
	}

	@Override
	public void saveNotReturn() throws Exception {

		list.clear();
		objetoSelecionado = cidadeController.merge(objetoSelecionado);
		list.add(objetoSelecionado);
		objetoSelecionado = new Cidade();
		sucesso();
	}

	@Override
	public void saveEdit() throws Exception {

		saveNotReturn();
	}

	@Override
	public String novo() throws Exception {

		setarVariaveisNulas();

		return url;
	}

	@Override
	public void setarVariaveisNulas() throws Exception {

		list.clear();
		objetoSelecionado = new Cidade();

	}

	@Override
	public String editar() throws Exception {

		return url;
	}

	@Override
	public void excluir() throws Exception {

		objetoSelecionado = (Cidade) cidadeController.getSession().get(getClassImplement(),
				objetoSelecionado.getCidade_id());
		cidadeController.delete(objetoSelecionado);
		list.remove(objetoSelecionado);
		objetoSelecionado = new Cidade();
		sucesso();
	}

	public Cidade getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Cidade objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	public String getUrl() {
		return url;
	}

	public List<Cidade> getList() throws Exception {

		list = cidadeController.findList(getClassImplement());

		return list;
	}

	@Override
	protected Class<Cidade> getClassImplement() {
		return Cidade.class;
	}

	@Override
	public String redirecionarFindEntidade() throws Exception {

		setarVariaveisNulas();
		return urlFind;
	}

	@Override
	protected InterfaceCrud<Cidade> getController() {
		return cidadeController;
	}

}
