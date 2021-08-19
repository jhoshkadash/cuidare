package model.vo;

import java.util.Scanner;

class principal
{
	public static void main (String[]args)
	{
		Scanner Leitura = new Scanner(System.in);
		AtendenteVO recepcao = new AtendenteVO;
		ConsultaVO consulta = new ConsultaVO;
		GerenteVO gerente = new GerenteVO;
		MedicoVO medico = new MedicoVO;
		PacienteVO paciente = new PacienteVO;
		ProntuarioVO prontuario = new ProntuarioVO;
		UsarioVO user = new UsuarioVO;
		
		//criar um novo atendente
		recepcao = new AtendenteVO  ("02298723411", "Geraldinho");
		//criar um gerente
		gerente = new GerenteVO ("Pedro", "PedrinhoGerente", "senhadopedrinho");
		//criar um novo médico
		medico = new MedicoVO("00034595698", "9898241234", "Rua dos milagres, 234, bairro palmeiras", "Laercio Calvacante Gomes", "400");
		//criar um novo paciente
		paciente = new PacienteVO("67341034522","Rua do pão, 987, Bairro Padaria" ,"Perisvaldo Souza Silva");
		//criar um novo prontuario
		prontuario = new Prontuario("Rivotril", "Paciente sofreu um acidente de moto e quebrou o nariz");
		//criar um novo usuário
		user = new UsuarioVO("PedrinhoGerente", "senhadopedrinho");

	}
}
