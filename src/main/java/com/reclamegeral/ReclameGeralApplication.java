package com.reclamegeral;

import javax.swing.JOptionPane;

import com.reclamegeral.dao.PessoaDAO;
import com.reclamegeral.model.Pessoa;

public class ReclameGeralApplication {
	public static void main(String[] args) {

		// Obter dados do usuário via JOptionPane
		String nome = JOptionPane.showInputDialog("Digite o nome:");
		String email = JOptionPane.showInputDialog("Digite o email:");
		String telefone = JOptionPane.showInputDialog("Digite o telefone:");

		// Criar nova instância da classe Pessoa
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setEmail(email);
		pessoa.setTelefone(telefone);

		// Criar instância do DAO
		PessoaDAO dao = new PessoaDAO();

		// Salvar pessoa no banco de dados usando o DAO
		dao.salvar(pessoa);

		// Exibir mensagem de sucesso
		JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
	}
}