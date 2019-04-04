package br.com.project.model.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.primefaces.json.JSONObject;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "mensagem")
@SequenceGenerator(name = "mensagem_seq", sequenceName = "mensagem_seq", initialValue = 1, allocationSize = 1)
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "mensagem_id", principal = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensagem_seq")
	private Long mensagem_id;

	@IdentificaCampoPesquisa(descricaoCampo = "Origem", campoConsulta = "user_origem.ent_nomeFantasia", principal = 2)
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_origem", nullable = false)
	@ForeignKey(name = "user_origem_fk")
	private Entidade user_origem = new Entidade();

	@IdentificaCampoPesquisa(descricaoCampo = "Destino", campoConsulta = "user_origem.ent_nomeFantasia", principal = 3)
	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_destino", nullable = false)
	@ForeignKey(name = "user_destino_fk")
	private Entidade user_destino = new Entidade();

	@Column(nullable = false)
	private Boolean mensagem_lido = Boolean.FALSE;

	@IdentificaCampoPesquisa(descricaoCampo = "Data", campoConsulta = "mensagem_dataHora")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date mensagem_dataHora = new Date();

	@IdentificaCampoPesquisa(descricaoCampo = "Assunto", campoConsulta = "mensagem_assunto")
	@Column(length = 100, nullable = false)
	private String mensagem_assunto;

	@IdentificaCampoPesquisa(descricaoCampo = "Mensagem", campoConsulta = "mensagem_mensagem", principal = 1)
	@Column(length = 1000, nullable = false)
	private String mensagem_mensagem;

	private Boolean mensagem_exigirResposta = false;

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getMensagem_id() {
		return mensagem_id;
	}

	public void setMensagem_id(Long mensagem_id) {
		this.mensagem_id = mensagem_id;
	}

	public Entidade getUser_origem() {
		return user_origem;
	}

	public void setUser_origem(Entidade user_origem) {
		this.user_origem = user_origem;
	}

	public Entidade getUser_destino() {
		return user_destino;
	}

	public void setUser_destino(Entidade user_destino) {
		this.user_destino = user_destino;
	}

	public Boolean getMensagem_lido() {
		return mensagem_lido;
	}

	public void setMensagem_lido(Boolean mensagem_lido) {
		this.mensagem_lido = mensagem_lido;
	}

	public Date getMensagem_dataHora() {
		return mensagem_dataHora;
	}

	public void setMensagem_dataHora(Date mensagem_dataHora) {
		this.mensagem_dataHora = mensagem_dataHora;
	}

	public String getMensagem_assunto() {
		return mensagem_assunto;
	}

	public void setMensagem_assunto(String mensagem_assunto) {
		this.mensagem_assunto = mensagem_assunto;
	}

	public String getMensagem_mensagem() {
		return mensagem_mensagem;
	}

	public void setMensagem_mensagem(String mensagem_mensagem) {
		this.mensagem_mensagem = mensagem_mensagem;
	}

	public Boolean getMensagem_exigirResposta() {
		return mensagem_exigirResposta;
	}

	public void setMensagem_exigirResposta(Boolean mensagem_exigirResposta) {
		this.mensagem_exigirResposta = mensagem_exigirResposta;
	}

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mensagem_id == null) ? 0 : mensagem_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (mensagem_id == null) {
			if (other.mensagem_id != null)
				return false;
		} else if (!mensagem_id.equals(other.mensagem_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensagem [mensagem_id=" + mensagem_id + ", mensagem_assunto=" + mensagem_assunto
				+ ", mensagem_mensagem=" + mensagem_mensagem + "]";
	}

	public JSONObject getJson() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("mensagem_id", mensagem_id);
		map.put("mensagem_lido", mensagem_lido);
		map.put("mensagem_assunto", mensagem_assunto);
		return new JSONObject(map);
	}
}
