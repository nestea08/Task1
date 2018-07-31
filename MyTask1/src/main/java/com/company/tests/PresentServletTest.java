package com.company.tests;

import com.company.controller.servlets.PresentServlet;
import com.company.model.PresentInitializer;
import com.company.model.entities.Present;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PresentServletTest {
    private PresentServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private Present present;
    private String index = "/WEB-INF/view/index.jsp";

    @Before
    public void init() {
        servlet = new PresentServlet();
        servlet.init();
        present = PresentInitializer.initialize();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(index)).thenReturn(dispatcher);
    }

    @Test
    public void testGeneralDoGet() throws ServletException, IOException {
        servlet.doGet(request, response);
        verify(request, times(1)).getRequestDispatcher(index);
        verify(dispatcher, times(1)).forward(request, response);
    }

    @Test
    public void testDoGetWithSorting() throws ServletException, IOException {
        present.sortSweetsByCost();
        when(request.getParameter("sortType")).thenReturn("cost");
        servlet.doGet(request, response);
        assertEquals(present.getSweets(), servlet.getPresent().getSweets());
    }

    @Test
    public void testDoGetWithSearchingBySugar() throws ServletException, IOException {
        when(request.getParameter("minSugar")).thenReturn("9");
        when(request.getParameter("maxSugar")).thenReturn("25");
        servlet.doGet(request, response);
        verify(request, times(1)).setAttribute("sweets", present.getSweetsBySugar(9,25));
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        when(request.getParameter("cost")).thenReturn("");
        when(request.getParameter("weight")).thenReturn("");
        when(request.getParameter("sugar")).thenReturn("");
        servlet.doPost(request, response);
        verify(request, times(1)).getRequestDispatcher(index);
        verify(dispatcher, times(1)).forward(request, response);
    }

    @Test
    public void testDoPostWithSweetAdding() throws ServletException, IOException {
        when(request.getParameter("sweetType")).thenReturn("candy");
        when(request.getParameter("cost")).thenReturn("20");
        when(request.getParameter("weight")).thenReturn("20");
        when(request.getParameter("sugar")).thenReturn("20");
        servlet.doPost(request, response);
        assertEquals(4, servlet.getPresent().getSweets().size());
    }



}