package com.legendary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class AdversaryController {

    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    AdversaryJDBCTemplate adversaryJDBCTemplate =
            (AdversaryJDBCTemplate)context.getBean("adversaryJDBCTemplate");

    @RequestMapping("/create/{name}/power/{power}")
    public String create(
            @PathVariable("name") String name,
            @PathVariable("power") int power
            ) {
		adversaryJDBCTemplate.create(name, power);
        return "Adversary Created";
    }


    @RequestMapping(value = "/retrieve/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String retrieve(
        @PathVariable("name") String name) {
        if (name == "All") return adversaryJDBCTemplate.listAdversaries().toString();
        return retrieveAdversary(name).toString();
    }

    public Adversary retrieveAdversary(String name) {
        Adversary adversary = adversaryJDBCTemplate.getAdversary(name);
        return adversary;
    }


    @RequestMapping(value = "/update/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String update(
            @PathVariable("name") String name,
            @RequestParam("name") String newName,
            @RequestParam("power") int power) {
        adversaryJDBCTemplate.update(name, newName, power);
        return retrieveAdversary(newName).toString();
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(
            @PathVariable("name") String name) {
        adversaryJDBCTemplate.delete(name);
        return name + " Deleted";
    }
}
