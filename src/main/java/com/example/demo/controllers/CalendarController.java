//package com.example.demo.controllers;
//
//import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.time.format.TextStyle;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//@Controller
//public class CalendarController {
//
//    @GetMapping("/calendar")
//    public String showCalendar(Model model) {
//        LocalDate currentDate = LocalDate.now();
//        int year = currentDate.getYear();
//        int month = currentDate.getMonthValue();
//        int daysInMonth = currentDate.lengthOfMonth();
//        List<String> dates = new ArrayList<>();
//
//        // Заповнення списку дат з поточного місяця
//        for (int day = 1; day <= daysInMonth; day++) {
//            LocalDate date = LocalDate.of(year, month, day);
//            String dateStr = date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("uk")));
//            String dayOfWeekStr = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("uk"));
//            dates.add(dayOfWeekStr + " " + dateStr);
//        }
//
//        model.addAttribute("dates", dates);
//
//        return "calendar";
//    }
//
//}
