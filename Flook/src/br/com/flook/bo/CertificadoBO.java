package br.com.flook.bo;
import java.util.List;

import br.com.flook.beans.Certificado;
import br.com.flook.dao.CertificadoDAO;
/**
* Responável por todas as Regras de negócio e padronizações do Certificado
* 1°) A quantidades de caracteres do atributo certificado não pode ser igual 0 nem meno que 0
* 2°) O codigo da Curso não poder ser igual a 0
* 3°) O codigo da Instituição não poder ser igual a 0
* 4°) O codigo da Usuario não poder ser igual a 0
* @author DENIS BRIAN CANOLA
* @author FELIPE HONÓRIO CAMARGO
* @author RAFAEL MACHADO CARDOSO
* @author MATHEUS APRIGIO DA SILVA
* @author JEFFREY RODRIGUES INNOCENCIO
* @version 1.0
* @since 1.0
* @see br.com.flook.beans.Certificado
* @see br.com.flook.dao.CertificadoBO
*/
public class CertificadoBO {
	/**
	 * Este método ira validar e repassar o objeto Certificado para a classe CertificadoBO
	 * @param obj Este parâmetro representa um objeto Curso do Beans
	 * @return O método retorna um valor booleano
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static boolean novoCertificado(Certificado obj) throws Exception{
		
		if(obj.getCertificado().length() == 0 || obj.getCertificado().length() > 0)
			return false;
		
		if(CursoBO.obterCursoPorCodigo(obj.getCurso().getCodigo()).getCodigo() == 0)
			return false;
		
		if(InstituicaoBO.obterPorCodigo(obj.getInstituicao().getCodigo()).getCodigo() == 0)
			return false;
		
		if(UsuarioBO.obterPorCodigo(obj.getUsuario().getCodigo()).getCodigo() == 0)
			return false;
		
		CertificadoDAO dao = new CertificadoDAO();
		boolean result = dao.gravar(obj);
		dao.fechar();		
		return result;
		
	}
	/**
	 * Este método ira o obter o Certificado por Usuario
	 * @param cod Este parâmetro representa o codigo do objeto Certificado
	 * @return O método retorna os Certificados encontrados referente ao Usuário
	 * @throws Exception Tratado a exceção checked SQLExceptio
	 * @author DENIS BRIAN CANOLA
	 */
	public static List<Certificado> obterCertificadoPorUsuario(int cod) throws Exception{
		CertificadoDAO dao = new CertificadoDAO();
		List<Certificado> certificados = dao.obterPorUsuario(cod);
		dao.fechar();
		return certificados;
	}
}
