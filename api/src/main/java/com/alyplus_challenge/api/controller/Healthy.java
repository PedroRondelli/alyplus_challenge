package com.alyplus_challenge.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/healthy")
public class Healthy {
  @GetMapping
  public String healthCheck() {
    return "API is healthy";
  }
}
