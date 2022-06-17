package br.com.app_cadastro.adapter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.app_cadastro.domain.entity.Pessoa;
import br.com.app_cadastro.domain.vo.v1.PessoaVO;

public class DozerConverterTest {

	// MOCK= criar objeto com a informaçãoque vai ser testatda

	private Pessoa mockEntity(Long numero) {

		Pessoa pessoa = new Pessoa();
		pessoa.setId(0l);
		pessoa.setNome("Nome teste: " + numero);
		pessoa.setSobrenome("Sobrenome teste: " + numero);
		pessoa.setNomeSocial("NomeSocial teste: " + numero);
		pessoa.setEmail("Email teste: " + numero);
		return pessoa;

	}

	private List<Pessoa> mockEntityList() {

		List<Pessoa> pessoas = new ArrayList<>();
		for (Long i = 0l; i < 5; i++) {
			pessoas.add(mockEntity(i));
		}
		return pessoas;

	}

	private PessoaVO mockEntityVO(Long numero) {

		PessoaVO pessoa = new PessoaVO();
		pessoa.setKey(0l);
		pessoa.setNome("Nome teste: " + numero);
		pessoa.setSobrenome("Sobrenome teste: " + numero);
		pessoa.setNomeSocial("NomeSocial teste: " + numero);
		pessoa.setEmail("Email teste: " + numero);
		return pessoa;

	}

	private List<PessoaVO> mockEntityListVO() {

		List<PessoaVO> pessoas = new ArrayList<>();
		for (Long i = 0l; i < 5; i++) {
			pessoas.add(mockEntityVO(i));
		}
		return pessoas;

	}

	// Casos de test

	@Test
	public void parseEntityToVOTest() {// passando de uma entidade para um VO

		PessoaVO output = DozerConverter.parseObject(mockEntity(0l), PessoaVO.class);
		Assert.assertEquals(Long.valueOf(0l), output.getKey());
		Assert.assertEquals("Nome teste: 0", output.getNome());
		Assert.assertEquals("Sobrenome teste: 0", output.getSobrenome());
		Assert.assertEquals("NomeSocial teste: 0", output.getNomeSocial());
		Assert.assertEquals("Email teste: 0", output.getEmail());

	}

	@Test
	public void parseEntityListToVOListTest() {
		List<PessoaVO> outputList = DozerConverter.parseListObject(mockEntityList(), PessoaVO.class);

		PessoaVO outputZero = outputList.get(0);

		Assert.assertEquals(Long.valueOf(0l), outputZero.getKey());
		Assert.assertEquals("Nome teste: 0", outputZero.getNome());
		Assert.assertEquals("Sobrenome teste: 0", outputZero.getSobrenome());
		Assert.assertEquals("NomeSocial teste: 0", outputZero.getNomeSocial());
		Assert.assertEquals("Email teste: 0", outputZero.getEmail());

	}

	@Test
	public void parseVOToEntityTest() {
		Pessoa output = DozerConverter.parseObject(mockEntityVO(0l), Pessoa.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Nome teste: 0", output.getNome());
		Assert.assertEquals("Sobrenome teste: 0", output.getSobrenome());
		Assert.assertEquals("NomeSocial teste: 0", output.getNomeSocial());
		Assert.assertEquals("Email teste: 0", output.getEmail());
	}

	@Test
	public void parserVOListToEntityListTest() {
		List<Pessoa> outputList = DozerConverter.parseListObject(mockEntityListVO(), Pessoa.class);
		Pessoa outputZero = outputList.get(0);
		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("Nome teste: 0", outputZero.getNome());
		Assert.assertEquals("Sobrenome teste: 0", outputZero.getSobrenome());
		Assert.assertEquals("NomeSocial teste: 0", outputZero.getNomeSocial());
		Assert.assertEquals("Email teste: 0", outputZero.getEmail());

	}
}
