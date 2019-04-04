package br.com.project.model.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import br.com.project.annotation.IdentificaCampoPesquisa;

import com.sun.istack.internal.NotNull;

@Audited
@Entity
@Table(name = "estado")
@SequenceGenerator(name = "estado_seq", sequenceName = "estado_seq", initialValue = 1, allocationSize = 1)
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "estado_id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_seq")
	private Long estado_id;

	@Column(length = 10, nullable = true)
	private String estado_uf;

	@IdentificaCampoPesquisa(descricaoCampo = "Nome", campoConsulta = "estado_descricao", principal = 1)
	@Column(length = 100, nullable = false)
	private String estado_descricao;

	@NotAudited
	@OneToMany(mappedBy = "estado", orphanRemoval = false)
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE,
			CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private List<Cidade> cidades = new ArrayList<Cidade>();

	@Basic
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pais")
	@NotNull
	@ForeignKey(name = "pais_fk")
	private Pais pais = new Pais();

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getestado_id() {
		return estado_id;
	}

	public void setestado_id(Long estado_id) {
		this.estado_id = estado_id;
	}

	public String getestado_uf() {
		return estado_uf;
	}

	public void setestado_uf(String estado_uf) {
		this.estado_uf = estado_uf;
	}

	public String getestado_descricao() {
		return estado_descricao;
	}

	public void setestado_descricao(String estado_descricao) {
		this.estado_descricao = estado_descricao;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		result = prime * result + ((estado_id == null) ? 0 : estado_id.hashCode());
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
		Estado other = (Estado) obj;
		if (estado_id == null) {
			if (other.estado_id != null)
				return false;
		} else if (!estado_id.equals(other.estado_id))
			return false;
		return true;
	}

}
