package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.CidadeController;
import br.com.project.model.classes.Cidade;

@Controller
@Scope(value = "session")
@ManagedBean(name = "cidadeBeanView")
public class CidadeBeanView extends BeanManagedViewAbstract {

	private static final long serialVersionUID = 1L;

	private String url = "/cadastro/cad_cidade.jsf?faces-redirect=true";

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
	public String novo() throws Exception {

		objetoSelecionado = new Cidade();

		return url;
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

		list = cidadeController.findList(Cidade.class);

		return list;
	}

}
