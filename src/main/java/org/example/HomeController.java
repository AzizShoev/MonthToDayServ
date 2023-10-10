
package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String month, Model model) {
        int daysInMonth = getDaysInMonth(month);
        model.addAttribute("selectedMonth", month);
        model.addAttribute("daysInMonth", daysInMonth);
        return "result";
    }

    private int getDaysInMonth(String month) {
        // Реализуйте здесь логику определения количества дней в месяце
        // В этом примере, для упрощения, используется фиксированное значение
        // для некоторых месяцев
        switch (month) {
            case "jan":
            case "mar":
            case "may":
            case "jul":
            case "aug":
            case "oct":
            case "dec":
                return 31;
            case "apr":
            case "jun":
            case "sep":
            case "nov":
                return 30;
            case "feb":
                return 28; // В этом примере не учитывается високосный год
            default:
                return -1; // Неправильный месяц
        }
    }
}
