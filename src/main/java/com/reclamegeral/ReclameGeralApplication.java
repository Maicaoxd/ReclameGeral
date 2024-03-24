package com.reclamegeral;

import java.util.List;

import javax.swing.JOptionPane;

import com.reclamegeral.controller.UsuarioController;
import com.reclamegeral.model.Usuario;

public class ReclameGeralApplication {
	public static void main(String[] args) {
		
		
		UsuarioController usuarioController = new UsuarioController();

		while (true) {
			String[] options = { "Inserir", "Pesquisar Todos", "Pesquisar por ID", "Atualizar", "Apagar", "Sair" };
			int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			switch (choice) {
			case 0: // Inserir
				String nome = JOptionPane.showInputDialog("Digite o nome do usuário:");
				if (nome != null) {
					Usuario novoUsuario = new Usuario(choice, choice, null, nome, nome, nome, nome, nome, nome, null);
					usuarioController.inserirUsuario(novoUsuario);
					JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
				}
				break;
			case 1: // Pesquisar Todos
				List<Usuario> usuarios = usuarioController.pesquisarTodos();
				StringBuilder sb = new StringBuilder("Usuários cadastrados:\n");
				for (Usuario usuario : usuarios) {
					sb.append(usuario.toString()).append("\n");
				}
				JOptionPane.showMessageDialog(null, sb.toString());
				break;
			case 2: // Pesquisar por ID
				String idStr = JOptionPane.showInputDialog("Digite o ID do usuário:");
				if (idStr != null) {
					try {
						long id = Long.parseLong(idStr);
						Usuario usuarioEncontrado = usuarioController.pesquisarUmUsuario(id);
						if (usuarioEncontrado != null) {
							JOptionPane.showMessageDialog(null, "Usuário encontrado:\n" + usuarioEncontrado);
						} else {
							JOptionPane.showMessageDialog(null, "Usuário não encontrado com ID: " + id);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "ID inválido. Digite um número válido.");
					}
				}
				break;
/*			case 3: // Atualizar
				String idAtualizarStr = JOptionPane.showInputDialog("Digite o ID do usuário a ser atualizado:");
				if (idAtualizarStr != null) {
					try {
						long idAtualizar = Long.parseLong(idAtualizarStr);
						Usuario usuarioAtualizado = new Usuario(idAtualizar, "Novo Nome");
						usuarioController.atualizar(usuarioAtualizado);
						JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "ID inválido. Digite um número válido.");
					}
				}
				break;*/
			case 4: // Apagar
				String idApagarStr = JOptionPane.showInputDialog("Digite o ID do usuário a ser removido:");
				if (idApagarStr != null) {
					try {
						long idApagar = Long.parseLong(idApagarStr);
						usuarioController.apagar(idApagar);
						JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "ID inválido. Digite um número válido.");
					}
				}
				break;
			case 5: // Sair
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}
}
