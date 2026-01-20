package com.hanifomar.procurement_app.dashboard.controller;

import com.hanifomar.procurement_app.dashboard.dto.DashboardResponse;
import com.hanifomar.procurement_app.dashboard.service.impl.DashboardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardServiceImpl dashboardService;

    @GetMapping
    public DashboardResponse getDashboard() {
        return dashboardService.getDashboardData();
    }
}
