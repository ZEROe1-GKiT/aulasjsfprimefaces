package br.com.project.model.classes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "titulo")
@SequenceGenerator(name = "titulo_seq", sequenceName = "titulo_seq", initialValue = 1, allocationSize = 1)
public class Titulo implements Serializable {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "titulo_id", principal = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "titulo_seq")
	private Long titulo_id;

	@IdentificaCampoPesquisa(descricaoCampo = "Origem", campoConsulta = "titulo_origem", principal = 2)
	private String titulo_descricao;

	@IdentificaCampoPesquisa(descricaoCampo = "Valor R$", campoConsulta = "titulo_valor")
	@Column(scale = 4, precision = 15)
	private BigDecimal titulo_valor = BigDecimal.ZERO;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date titulo_datahora = new Date();

	private Boolean titulo_baixado = Boolean.FALSE;

	@IdentificaCampoPesquisa(descricaoCampo = "Tipo", campoConsulta = "titulo_tipo")
	private String titulo_tipo;

	@IdentificaCampoPesquisa(descricaoCampo = "Valor Pago R$", campoConsulta = "titulo_valorpago")
	@Column(scale = 4, precision = 15)
	private BigDecimal titulo_valorpago = BigDecimal.ZERO;

	@IdentificaCampoPesquisa(descricaoCampo = "Usuário abertura", campoConsulta = "ent_codigoabertura.ent_nomefantasia", principal = 1)
	@Basic
	@ManyToOne
	@JoinColumn(name = "ent_codigoabertura", nullable = false, updatable = false)
	@ForeignKey(name = "ent_codigoabertura_fk")
	private Entidade ent_codigoabertura = new Entidade();

	@IdentificaCampoPesquisa(descricaoCampo = "Entidade responsável", campoConsulta = "ent_codigo.ent_nomefantasia")
	@Basic
	@ManyToOne
	@JoinColumn(name = "ent_codigo", nullable = false)
	@ForeignKey(name = "ent_codigo_fk")
	private Entidade ent_codigo = new Entidade();

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getTitulo_id() {
		return titulo_id;
	}

	public void setTitulo_id(Long titulo_id) {
		this.titulo_id = titulo_id;
	}

	public String getTitulo_descricao() {
		return titulo_descricao;
	}

	public void setTitulo_descricao(String titulo_descricao) {
		this.titulo_descricao = titulo_descricao;
	}

	public BigDecimal getTitulo_valor() {
		return titulo_valor;
	}

	public void setTitulo_valor(BigDecimal titulo_valor) {
		this.titulo_valor = titulo_valor;
	}

	public Date getTitulo_datahora() {
		return titulo_datahora;
	}

	public void setTitulo_datahora(Date titulo_datahora) {
		this.titulo_datahora = titulo_datahora;
	}

	public Boolean getTitulo_baixado() {
		return titulo_baixado;
	}

	public void setTitulo_baixado(Boolean titulo_baixado) {
		this.titulo_baixado = titulo_baixado;
	}

	public String getTitulo_tipo() {
		return titulo_tipo;
	}

	public void setTitulo_tipo(String titulo_tipo) {
		this.titulo_tipo = titulo_tipo;
	}

	public BigDecimal getTitulo_valorpago() {
		return titulo_valorpago;
	}

	public void setTitulo_valorpago(BigDecimal titulo_valorpago) {
		this.titulo_valorpago = titulo_valorpago;
	}

	public Entidade getEnt_codigoabertura() {
		return ent_codigoabertura;
	}

	public void setEnt_codigoabertura(Entidade ent_codigoabertura) {
		this.ent_codigoabertura = ent_codigoabertura;
	}

	public Entidade getEnt_codigo() {
		return ent_codigo;
	}

	public void setEnt_codigo(Entidade ent_codigo) {
		this.ent_codigo = ent_codigo;
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
		result = prime * result + ((titulo_descricao == null) ? 0 : titulo_descricao.hashCode());
		result = prime * result + ((titulo_id == null) ? 0 : titulo_id.hashCode());
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
		Titulo other = (Titulo) obj;
		if (titulo_descricao == null) {
			if (other.titulo_descricao != null)
				return false;
		} else if (!titulo_descricao.equals(other.titulo_descricao))
			return false;
		if (titulo_id == null) {
			if (other.titulo_id != null)
				return false;
		} else if (!titulo_id.equals(other.titulo_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Titulo [titulo_id=" + titulo_id + "]";
	}

}
