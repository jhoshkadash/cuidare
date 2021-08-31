import java.util.Scanner;


class principal
{
	public static void main (String[]args)
	{
		Scanner leitura = new Scanner(System.in);
		int Contadorid = 0;
		AtendenteVO recepcao = new AtendenteVO();
		ConsultaVO consulta = new ConsultaVO();
		GerenteVO gerente = new GerenteVO();
		MedicoVO medico = new MedicoVO();
		PacienteVO paciente = new PacienteVO();
		ProntuarioVO prontuario = new ProntuarioVO();
		UsuarioVO user = new UsuarioVO();
		
		//criar um novo atendente
		
		System.out.println("Digite o nome do atendente");
		recepcao.setNome(leitura.nextLine());

		System.out.println("Digite o CPF do atendente");
		recepcao.setCpf(leitura.nextLine());

		System.out.println("Nome do atendente");
		System.out.println(recepcao.getNome());
		System.out.println("CPF do atendente");
		System.out.println(recepcao.getCpf());
		
		

		
		
		//criar um gerente
		System.out.println("Digite o nome do gerente");
		gerente.setNome(leitura.nextLine());
		gerente.setId("1");
		

		System.out.println("Nome do Gerente");
		System.out.println(gerente.getNome());
		System.out.println("ID do gerente");
		System.out.println(gerente.getId());
		
		
		
		//criar um novo médico
		
		System.out.println("Digite o nome do Médico");
		medico.setNome(leitura.nextLine());

		System.out.println("Digite o CPF do Médico");
		medico.setCpf(leitura.nextLine());
		
		System.out.println("Digite o CRM do Médico");
		medico.setCrm(leitura.nextLine());

		System.out.println("Digite o endereço do Médico");
		medico.setEndereco(leitura.nextLine());

		System.out.println("Digite o valor da consulta do Médico");
		medico.setValorconsulta(leitura.nextDouble());



		System.out.print("o médico ");
		System.out.print(medico.getNome());
		System.out.print(" de CRM:");
		System.out.print(medico.getCrm());
		System.out.print(" e de CPF: ");
		System.out.print(medico.getCpf());
		System.out.print(" mora no endereço ");
		System.out.print(medico.getEndereco());
		System.out.print(" cobra o valor de ");
		System.out.print(medico.getValorconsulta());
		System.out.print("R$ por consulta");





		/*
		//criar um novo paciente
		paciente = new PacienteVO("67341034522","Rua do pão, 987, Bairro Padaria" ,"Perisvaldo Souza Silva");
		//criar um novo prontuario
		prontuario = new Prontuario("Rivotril", "Paciente sofreu um acidente de moto e quebrou o nariz");
		//criar um novo usuário
		user = new UsuarioVO("PedrinhoGerente", "senhadopedrinho");*/

	}
}