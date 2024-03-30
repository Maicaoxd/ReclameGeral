package com.reclamegeral.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.AvaliacaoController;
import com.reclamegeral.controller.CategoriaController;
import com.reclamegeral.controller.EmpresaController;
import com.reclamegeral.controller.PessoaController;
import com.reclamegeral.controller.ReclamacaoController;
import com.reclamegeral.controller.RespostaController;
import com.reclamegeral.model.Avaliacao;
import com.reclamegeral.model.Categoria;
import com.reclamegeral.model.Empresa;
import com.reclamegeral.model.Pessoa;
import com.reclamegeral.model.Reclamacao;
import com.reclamegeral.model.Resposta;

public class ReclameGeralApplication {
	public static void main(String[] args) {
		// Mostra o menu principal
		String[] entidades = { "Pessoa", "Empresa", "Categoria", "Reclamação", "Resposta", "Avaliação" };
		String entidadeSelecionada = (String) JOptionPane.showInputDialog(null, "Selecione a entidade:",
				"Menu Principal", JOptionPane.PLAIN_MESSAGE, null, entidades, entidades[0]);

		// Se o usuário cancelar, encerra o programa
		if (entidadeSelecionada == null) {
			System.exit(0);
		}

		// Mostra o menu de operações CRUD
		String[] operacoes = { "Inserir", "Listar Todos", "Pesquisar Um", "Atualizar", "Deletar" };
		String operacaoSelecionada = (String) JOptionPane.showInputDialog(null,
				"Selecione a operação " + entidadeSelecionada + ":", "Menu de Operações", JOptionPane.PLAIN_MESSAGE,
				null, operacoes, operacoes[0]);

		// Se o usuário cancelar, encerra o programa
		if (operacaoSelecionada == null) {
			System.exit(0);
		}

		// Executa a operação selecionada com base na entidade
		switch (entidadeSelecionada) {
		case "Pessoa":
			executarOperacaoPessoa(operacaoSelecionada);
			break;
		case "Empresa":
			executarOperacaoEmpresa(operacaoSelecionada);
			break;
		case "Categoria":
			executarOperacaoCategoria(operacaoSelecionada);
			break;
		case "Reclamação":
			executarOperacaoReclamacao(operacaoSelecionada);
			break;
		case "Resposta":
			executarOperacaoResposta(operacaoSelecionada);
			break;
		case "Avaliação":
			executarOperacaoAvaliacao(operacaoSelecionada);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Entidade não suportada.", "Erro", JOptionPane.ERROR_MESSAGE);
			break;
		}

	}

	private static void executarOperacaoAvaliacao(String operacaoSelecionada) {
		AvaliacaoController avaliacaoController = new AvaliacaoController();

		switch (operacaoSelecionada) {
		case "Inserir":
			Avaliacao novaAvaliacao = avaliacaoController.obterDadosAvaliacao();
			avaliacaoController.inserirAvaliacao(novaAvaliacao);
			break;

		case "Listar Todos":
			List<Avaliacao> todasAsAvaliacoes = avaliacaoController.pesquisarTodos();
			avaliacaoController.exibirAvaliacoes(todasAsAvaliacoes);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da avaliação a ser pesquisada:"));
			Avaliacao avaliacaoPesquisada = avaliacaoController.pesquisarUmAvaliacao(idPesquisar);
			if (avaliacaoPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Avaliação encontrada:\n" + avaliacaoPesquisada.toString(),
						"Avaliação Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Avaliação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da avaliação a ser atualizada:"));
			Avaliacao avaliacaoParaAtualizar = avaliacaoController.pesquisarUmAvaliacao(idAtualizar);
			if (avaliacaoParaAtualizar != null) {
				Avaliacao dadosAtualizados = avaliacaoController.obterDadosAvaliacao();
				avaliacaoParaAtualizar = avaliacaoController.atualizarDadosAvaliacao(avaliacaoParaAtualizar,
						dadosAtualizados);
				avaliacaoController.atualizar(avaliacaoParaAtualizar);
				JOptionPane.showMessageDialog(null, "Avaliação atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Avaliação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da avaliação a ser deletada:"));
			Avaliacao avaliacaoParaDeletar = avaliacaoController.pesquisarUmAvaliacao(idDeletar);
			if (avaliacaoParaDeletar != null) {
				avaliacaoController.apagar(avaliacaoParaDeletar);
				JOptionPane.showMessageDialog(null, "Avaliação deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Avaliação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Avaliação.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	private static void executarOperacaoResposta(String operacao) {
		RespostaController respostaController = new RespostaController();

		switch (operacao) {
		case "Inserir":
			Resposta novaResposta = respostaController.obterDadosResposta();
			respostaController.inserirResposta(novaResposta);
			break;

		case "Listar Todos":
			List<Resposta> todasAsRespostas = respostaController.pesquisarTodos();
			respostaController.exibirRespostas(todasAsRespostas);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da resposta a ser pesquisada:"));
			Resposta respostaPesquisada = respostaController.pesquisarUmResposta(idPesquisar);
			if (respostaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Resposta encontrada:\n" + respostaPesquisada.toString(),
						"Resposta Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Resposta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da resposta a ser atualizada:"));
			Resposta respostaParaAtualizar = respostaController.pesquisarUmResposta(idAtualizar);
			if (respostaParaAtualizar != null) {
				Resposta dadosAtualizados = respostaController.obterDadosResposta();
				respostaParaAtualizar = respostaController.atualizarDadosResposta(respostaParaAtualizar,
						dadosAtualizados);
				respostaController.atualizar(respostaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Resposta atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Resposta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da resposta a ser deletada:"));
			Resposta respostaParaDeletar = respostaController.pesquisarUmResposta(idDeletar);
			if (respostaParaDeletar != null) {
				respostaController.apagar(respostaParaDeletar);
				JOptionPane.showMessageDialog(null, "Resposta deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Resposta não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Resposta.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	private static void executarOperacaoReclamacao(String operacao) {
		ReclamacaoController reclamacaoController = new ReclamacaoController();

		switch (operacao) {
		case "Inserir":
			Reclamacao novaReclamacao = reclamacaoController.obterDadosReclamacao();
			reclamacaoController.inserirReclamacao(novaReclamacao);
			break;

		case "Listar Todos":
			List<Reclamacao> todasAsReclamacoes = reclamacaoController.pesquisarTodos();
			reclamacaoController.exibirReclamacoes(todasAsReclamacoes);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamação a ser pesquisada:"));
			Reclamacao reclamacaoPesquisada = reclamacaoController.pesquisarUmReclamacao(idPesquisar);
			if (reclamacaoPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Reclamação encontrada:\n" + reclamacaoPesquisada.toString(),
						"Reclamação Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Reclamação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamação a ser atualizada:"));
			Reclamacao reclamacaoParaAtualizar = reclamacaoController.pesquisarUmReclamacao(idAtualizar);
			if (reclamacaoParaAtualizar != null) {
				Reclamacao dadosAtualizados = reclamacaoController.obterDadosReclamacao();
				reclamacaoParaAtualizar = reclamacaoController.atualizarDadosReclamacao(reclamacaoParaAtualizar,
						dadosAtualizados);
				reclamacaoController.atualizar(reclamacaoParaAtualizar);
				JOptionPane.showMessageDialog(null, "Reclamação atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Reclamação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da reclamação a ser deletada:"));
			Reclamacao reclamacaoParaDeletar = reclamacaoController.pesquisarUmReclamacao(idDeletar);
			if (reclamacaoParaDeletar != null) {
				reclamacaoController.apagar(reclamacaoParaDeletar);
				JOptionPane.showMessageDialog(null, "Reclamação deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Reclamação não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Reclamação.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	private static void executarOperacaoCategoria(String operacao) {
		CategoriaController categoriaController = new CategoriaController();

		switch (operacao) {
		case "Inserir":
			Categoria novaCategoria = categoriaController.obterDadosCategoria();
			categoriaController.inserirCategoria(novaCategoria);
			break;

		case "Listar Todos":
			List<Categoria> todasAsCategorias = categoriaController.pesquisarTodos();
			categoriaController.exibirCategorias(todasAsCategorias);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria a ser pesquisada:"));
			Categoria categoriaPesquisada = categoriaController.pesquisarUmCategoria(idPesquisar);
			if (categoriaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Categoria encontrada:\n" + categoriaPesquisada.toString(),
						"Categoria Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria a ser atualizada:"));
			Categoria categoriaParaAtualizar = categoriaController.pesquisarUmCategoria(idAtualizar);
			if (categoriaParaAtualizar != null) {
				Categoria dadosAtualizados = categoriaController.obterDadosCategoria();
				categoriaParaAtualizar = categoriaController.atualizarDadosCategoria(categoriaParaAtualizar,
						dadosAtualizados);
				categoriaController.atualizar(categoriaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da categoria a ser deletada:"));
			Categoria categoriaParaDeletar = categoriaController.pesquisarUmCategoria(idDeletar);
			if (categoriaParaDeletar != null) {
				categoriaController.apagar(categoriaParaDeletar);
				JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Categoria não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Categoria.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	private static void executarOperacaoEmpresa(String operacao) {
		EmpresaController empresaController = new EmpresaController();

		switch (operacao) {
		case "Inserir":
			Empresa novaEmpresa = empresaController.obterDadosEmpresa();
			empresaController.inserirEmpresa(novaEmpresa);
			break;

		case "Listar Todos":
			List<Empresa> todasAsEmpresas = empresaController.pesquisarTodos();
			empresaController.exibirEmpresas(todasAsEmpresas);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa a ser pesquisada:"));
			Empresa empresaPesquisada = empresaController.pesquisarUmEmpresa(idPesquisar);
			if (empresaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Empresa encontrada:\n" + empresaPesquisada.toString(),
						"Empresa Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa a ser atualizada:"));
			Empresa empresaParaAtualizar = empresaController.pesquisarUmEmpresa(idAtualizar);
			if (empresaParaAtualizar != null) {
				Empresa dadosAtualizados = empresaController.obterDadosEmpresa();
				empresaParaAtualizar = empresaController.atualizarDadosEmpresa(empresaParaAtualizar, dadosAtualizados);
				empresaController.atualizar(empresaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da empresa a ser deletada:"));
			Empresa empresaParaDeletar = empresaController.pesquisarUmEmpresa(idDeletar);
			if (empresaParaDeletar != null) {
				empresaController.apagar(empresaParaDeletar);
				JOptionPane.showMessageDialog(null, "Empresa deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Empresa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Empresa.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	private static void executarOperacaoPessoa(String operacao) {
		PessoaController pessoaController = new PessoaController();

		switch (operacao) {
		case "Inserir":
			Pessoa novaPessoa = pessoaController.obterDadosPessoa();
			pessoaController.inserirPessoa(novaPessoa);
			break;

		case "Listar Todos":
			List<Pessoa> todasAsPessoas = pessoaController.pesquisarTodos();
			pessoaController.exibirPessoas(todasAsPessoas);
			break;

		case "Pesquisar Um":
			Long idPesquisar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser pesquisada:"));
			Pessoa pessoaPesquisada = pessoaController.pesquisarUmPessoa(idPesquisar);
			if (pessoaPesquisada != null) {
				JOptionPane.showMessageDialog(null, "Pessoa encontrada:\n" + pessoaPesquisada.toString(),
						"Pessoa Encontrada", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Atualizar":
			Long idAtualizar = Long
					.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser atualizada:"));
			Pessoa pessoaParaAtualizar = pessoaController.pesquisarUmPessoa(idAtualizar);
			if (pessoaParaAtualizar != null) {
				Pessoa dadosAtualizados = pessoaController.obterDadosPessoa();
				pessoaParaAtualizar = pessoaController.atualizarDadosPessoa(pessoaParaAtualizar, dadosAtualizados);
				pessoaController.atualizar(pessoaParaAtualizar);
				JOptionPane.showMessageDialog(null, "Pessoa atualizada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "Deletar":
			Long idDeletar = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o ID da pessoa a ser deletada:"));
			Pessoa pessoaParaDeletar = pessoaController.pesquisarUmPessoa(idDeletar);
			if (pessoaParaDeletar != null) {
				pessoaController.apagar(pessoaParaDeletar);
				JOptionPane.showMessageDialog(null, "Pessoa deletada com sucesso.", "Sucesso",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Operação não suportada para Pessoa.", "Erro",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
