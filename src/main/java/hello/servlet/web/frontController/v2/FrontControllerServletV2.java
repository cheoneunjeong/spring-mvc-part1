package hello.servlet.web.frontController.v2;

import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "frontControllerV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private HashMap<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerV2 controllerV2 = controllerMap.get(req.getRequestURI());
        if (controllerV2 == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controllerV2.process(req, resp);
        view.render(req, resp);
    }
}
