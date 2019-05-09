package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.OcorrenciaDAO;
import br.com.fiap.entity.Ocorrencia;

public class OcorrenciaDAOImpl extends GenericDAOImpl<Ocorrencia, Integer> implements OcorrenciaDAO{

	public OcorrenciaDAOImpl(EntityManager em) {
		super(em);
	}

}
