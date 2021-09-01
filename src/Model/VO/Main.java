import java.util.Scanner;

class principal
{
	public static void main (String[]args)
	{
		Scanner leitura = new Scanner(System.in);	
		AtendenteVO recepcao = new AtendenteVO();
		GerenteVO gerente = new GerenteVO();
		MedicoVO medico = new MedicoVO();
		String txtValorConsulta;
		/*Scanner Leitura = new Scanner(System.in);
		ConsultaVO consulta = new ConsultaVO();
		
		MedicoVO medico = new MedicoVO();
		PacienteVO paciente = new PacienteVO();
		ProntuarioVO prontuario = new ProntuarioVO();
		UsuarioVO user = new UsuarioVO();*/
		
		//criar um novo atendente
		System.out.println("Digite o nome do atendente");
		recepcao.setNome(leitura.nextLine());
		System.out.println("Digite o CPF do atendente(não inserir . e -)");
		recepcao.setCpf(leitura.nextLine());

		System.out.println("**********************************");
		
		System.out.println("O nome do atendente é: " + recepcao.getNome() + " e o CPF do mesmo é :" + recepcao.getCpf());
		
		System.out.println("----------------------------------");
		//criar um gerente
		gerente.setNome("Pedro luis");
		gerente.setId("1");

		System.out.println("**********************************");
		
		System.out.println("O gerente do sistema é " + gerente.getNome() + " e o seu ID é: " + gerente.getId());
		
		System.out.println("----------------------------------");
		//criar um novo médico ("00034595698", "9898241234", "Rua dos milagres, 234, bairro palmeiras", "Laercio Calvacante Gomes", "400")
		System.out.println("Digite o nome do médico");
		medico.setNome(leitura.nextLine());
		System.out.println("Digite o endereço do médico");
		medico.setEndereco(leitura.nextLine());
		System.out.println("Digite o CPF do médico");
		medico.setCpf(leitura.nextLine());
		System.out.println("Digite o CRM do médico");
		medico.setCrm(leitura.nextLine());
		System.out.println("Digite o valor da consulta cobrado pelo médico");
		medico.setValorconsulta(Double.parseDouble(leitura.nextLine()));
		
		System.out.println("**********************************");
		
		System.out.println("O DR." + medico.getNome() + "  Mora no endereço " + medico.getEndereco() + " tem o CPF de número " + medico.getCpf() + " o seu crm é " + medico.getCrm() + " e ele cobra" + medico.getValorconsulta() + "R$");

		System.out.println("----------------------------------");
		/*//criar um novo paciente
		paciente = new PacienteVO("67341034522","Rua do pão, 987, Bairro Padaria" ,"Perisvaldo Souza Silva");
		//criar um novo prontuario
		prontuario = new Prontuario("Rivotril", "Paciente sofreu um acidente de moto e quebrou o nariz");
		//criar um novo usuário
		user = new UsuarioVO("PedrinhoGerente", "senhadopedrinho");*/

	}
}