package br.senai.sc.ti20151n1.pwa.crudaluno;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sc.ti20151n1.pwa.crudaluno.model.Mensagem;
import br.senai.sc.ti20151n1.pwa.crudaluno.modelo.Aluno;
import br.senai.sc.ti20151n1.pwa.crudaluno.modelo.AlunoRN;

@WebServlet(urlPatterns = "/alunocontrole")
public class AlunoControle extends HttpServlet {

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		Long id = Long.parseLong(req.getParameter("id"));
		AlunoRN alunoRN = new AlunoRN();

		if ("deletar".equals(cmd)) {
			try {
				alunoRN.deletar(id);
				req.setAttribute("msg", new Mensagem("info",
						"Excluído com sucesso!"));
			} catch (Exception e) {
				req.setAttribute("msg", new Mensagem("warning", e.getMessage()));
				e.printStackTrace();
			}
			req.getRequestDispatcher("/alunoLista.jsp").forward(req, resp);
		} else {
			try {
				req.setAttribute("aluno", alunoRN.buscarPorId(id));
			} catch (Exception e) {
				req.setAttribute("msg", new Mensagem("warning", e.getMessage()));
				e.printStackTrace();
			}
			req.getRequestDispatcher("/alunoForm.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		Aluno aluno = new Aluno();
		if (!req.getParameter("id").isEmpty()) {
			aluno.setId(Long.parseLong(req.getParameter("id")));
		}
		aluno.setEmail(req.getParameter("email"));
		aluno.setNome(req.getParameter("nome"));
		aluno.setNoticias(req.getParameter("noticias") != null);

		AlunoRN alunoRN = new AlunoRN();
		try {
			alunoRN.salvar(aluno);
			req.setAttribute("msg", new Mensagem("info", "Salvou"));
			req.getRequestDispatcher("/alunoLista.jsp").forward(req, resp);
		} catch (Exception e) {
			req.setAttribute("msg", new Mensagem("warning", e.getMessage()));
			e.printStackTrace();
			req.getRequestDispatcher("/alunoForm.jsp").forward(req, resp);
		}

	}
}
