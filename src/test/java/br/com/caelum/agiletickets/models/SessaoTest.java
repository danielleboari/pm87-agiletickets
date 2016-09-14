package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void deveReservarIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
        Integer total_ingressos=2;
		sessao.setTotalIngressos(total_ingressos);

        Integer qtd_reserva=1;
		Assert.assertTrue(sessao.podeReservar(qtd_reserva));
	}

	@Test
	public void naoDeveReservarIngressosIndisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		Integer total_ingressos=2;
		sessao.setTotalIngressos(total_ingressos);

		Integer qtd_reserva=3;
		Assert.assertFalse(sessao.podeReservar(qtd_reserva));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		Integer total_ingressos=5;
		sessao.setTotalIngressos(total_ingressos);

		Integer ingressos_reservados = 3;
		sessao.reserva(ingressos_reservados);
		
		
		int resultado_esperado=2;
		Assert.assertEquals(resultado_esperado, sessao.getIngressosDisponiveis().intValue());
	}
	
}
