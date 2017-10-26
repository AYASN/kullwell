package com.yandm.assir.controller;

import com.yandm.assir.service.RecipeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}