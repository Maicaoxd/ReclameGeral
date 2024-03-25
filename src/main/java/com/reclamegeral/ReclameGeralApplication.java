package com.reclamegeral;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.UsuarioController;
import com.reclamegeral.model.Usuario;

public class ReclameGeralApplication {
	public static void main(String[] args) {
		UsuarioController usuarioController = new UsuarioController();

		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Escolha uma opção:\n1. Inserir Usuário\n2. Listar Todos os Usuários\n3. Pesquisar Usuário por ID\n4. Atualizar Usuário\n5. Apagar Usuário\n6. Sair"));
			switch (opcao) {
			case 1:
				inserirUsuario(usuarioController);
				break;
			case 2:
				listarTodosUsuarios(usuarioController);
				break;
			case 3:
				pesquisarUsuarioPorId(usuarioController);
				break;
			case 4:
				atualizarUsuario(usuarioController);
				break;
			case 5:
				apagarUsuario(usuarioController);
				break;
			case 6:
				System.out.println("Saindo...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		} while (opcao != 6);
	}

	private static void inserirUsuario(UsuarioController usuarioController) {
		String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
		String email = JOptionPane.showInputDialog("Digite o email do usuário:");
		String senha = JOptionPane.showInputDialog("Digite a senha do usuário:");

		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome(nome);
		novoUsuario.setEmail(email);
		novoUsuario.setSenha(senha);

		usuarioController.inserirUsuario(novoUsuario);
		JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
	}

	private static void listarTodosUsuarios(UsuarioController usuarioController) {
		JOptionPane.showMessageDialog(null, "Lista de todos os usuários:\n" + usuarioController.pesquisarTodos());
	}

	private static void pesquisarUsuarioPorId(UsuarioController usuarioController) {
		long id = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do usuário a ser pesquisado:"));

		Usuario usuarioEncontrado = usuarioController.pesquisarUmUsuario(id);
		if (usuarioEncontrado != null) {
			JOptionPane.showMessageDialog(null, "Usuário encontrado:\n" + usuarioEncontrado);
		} else {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado com o ID: " + id);
		}
	}

	private static void atualizarUsuario(UsuarioController usuarioController) {
		long id = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do usuário a ser atualizado:"));

		Usuario usuarioEncontrado = usuarioController.pesquisarUmUsuario(id);
		if (usuarioEncontrado != null) {
			String novoNome = JOptionPane.showInputDialog("Digite o novo nome do usuário:");
			String novoEmail = JOptionPane.showInputDialog("Digite o novo email do usuário:");
			String novaSenha = JOptionPane.showInputDialog("Digite a nova senha do usuário:");

			usuarioEncontrado.setNome(novoNome);
			usuarioEncontrado.setEmail(novoEmail);
			usuarioEncontrado.setSenha(novaSenha);

			usuarioController.atualizar(usuarioEncontrado);
			JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado com o ID: " + id);
		}
	}

	private static void apagarUsuario(UsuarioController usuarioController) {
		long id = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do usuário a ser apagado:"));

		Usuario usuarioEncontrado = usuarioController.pesquisarUmUsuario(id);
		if (usuarioEncontrado != null) {
			usuarioController.apagar(usuarioEncontrado);
			JOptionPane.showMessageDialog(null, "Usuário apagado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado com o ID: " + id);
		}
	}
}
