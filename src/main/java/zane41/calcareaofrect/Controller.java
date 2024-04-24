package zane41.calcareaofrect;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/calcarea")
    public String  obshenie (@RequestParam(name = "a", defaultValue = "0") String a,
                             @RequestParam(name = "b", defaultValue = "0") String b,
                             Model model/*дополнительный парметр - словарь для испоьзования в шаблоне*/) {
        try {
            double storonaA = Double.parseDouble(a);
            double storonaB = Double.parseDouble(b);
            model.addAttribute("perimetr", storonaA*2 + storonaB*2);
            model.addAttribute("area", storonaA*storonaB);

        }
        catch (NumberFormatException e){
            model.addAttribute("errorMessg", "oshipka");
        }
        return "calcarea";
    }

    @GetMapping("/calcarea")//цепляет функцию к адресу страницы на сайте
    //метод возвращает шаблон и принимает на вход 2 параметра из запроса
    public String calcarea (@RequestParam(name = "a", defaultValue = "0") String a,
                      @RequestParam(name = "b", defaultValue = "0") String b,
                      Model model/*дополнительный парметр - словарь для испоьзования в шаблоне*/) {
        try {
            double storonaA = Double.parseDouble(a);
            double storonaB = Double.parseDouble(b);
            model.addAttribute("perimetr", storonaA*2 + storonaB*2);
            model.addAttribute("area", storonaA*storonaB);

        }
        catch (NumberFormatException e){
            model.addAttribute("errorMsg", "это было не число");
        }
        return "calcarea";
    }



}

