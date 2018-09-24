package br.com.flook.bo;
import java.util.List;

import br.com.flook.beans.Certificado;
import br.com.flook.dao.CertificadoDAO;

public class CertificadoBO {
	
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
	public static List<Certificado> obterCertificadoPorUsuario(int cod) throws Exception{
		CertificadoDAO dao = new CertificadoDAO();
		List<Certificado> certificados = dao.obterPorUsuario(cod);
		dao.fechar();
		return certificados;
	}
}
