/**
 * Author:    Niall Loughnane
 * Created:   08.08.2020
 *
 * This class is a controller class for processing statistics
 **/

package com.zinkworks.controller;

import com.zinkworks.model.Statistics;
import com.zinkworks.service.StatisticsService;
import com.zinkworks.utils.LoggingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/statistics")
@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/getStatistics")
    Statistics getStatistics() {
        LoggingUtils.logMessage("INFO", this.getClass().getSimpleName(), "Statistics", "Getting Statistics");
        return this.statisticsService.getAllStatistics();
    }

}
