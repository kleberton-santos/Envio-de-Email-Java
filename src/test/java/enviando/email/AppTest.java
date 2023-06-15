package enviando.email;

public class AppTest {

	
	@org.junit.Test
	public void testeEmail() throws Exception{
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		stringBuilderTextoEmail.append("testando <br/><br/>");
		stringBuilderTextoEmail.append("testando <br/><br/>");

		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail(
						"ti.klebersantos2@gmail.com",
						"Kleber",
						"Teste",
						stringBuilderTextoEmail.toString());
		enviaEmail.enviarEmail(true);
			
			Thread.sleep(5000);
		
	}
}
