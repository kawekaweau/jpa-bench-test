package testes;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
	Integer Id;
	static Long n= (long) 0;
	String descricao;
	String consulta;
	String query;
	Long tempoMedio;
	List<Long> tempos;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Long getTempoMedio() {
		return tempoMedio;
	}
	public void setTempoMedio(Long tempo) {
		if(tempoMedio==0){
			tempoMedio = tempo;
		}else{
			tempoMedio=(tempoMedio+tempo)/2;
		}
		
	}
	public List<Long> getTempos() {
		List<Long> t = tempos;
		return t;
	}

	public void addTempo(Long tempo){
		this.tempos.add(tempo);
		setTempoMedio(tempo);
	}
	public Resultado(Integer id, String descricao, Long tempo) {
		super();
		Id = id;
		this.consulta = descricao;
		this.descricao = descricao;
		this.tempoMedio = (long) 0;
		this.tempos = new ArrayList<>();
		addTempo(tempo);
		n++;
	}	

	public Resultado(Integer id, String descricao) {
		super();
		Id = id;
		this.consulta = descricao;
		this.descricao = descricao;
		n++;
		this.tempoMedio = (long) 0;
		this.tempos = new ArrayList<>();
	}
	@Override
	public String toString() {
		String t="";
		for (Long i:tempos){
			t+=String.format("+%d",i);
		}
		
		return consulta+"["+ query + "]: ("+t.substring(1)+")/"+tempos.size()+" tempoMedio: " + tempoMedio + ".";
	}	
	
	
}
