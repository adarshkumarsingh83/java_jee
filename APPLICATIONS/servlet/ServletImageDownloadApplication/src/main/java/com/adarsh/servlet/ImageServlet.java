package com.adarsh.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/9/12 11:16 AM#$
 */
public class ImageServlet extends HttpServlet {

    public ImageServlet() {
        System.out.println("ImageServlet constructor");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response = this.putImage(request, response);
    }


    private HttpServletResponse putImage(HttpServletRequest request, HttpServletResponse response) {


        return response;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response = this.getImage(request, response);
    }

    private HttpServletResponse getImage(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream servletOutputStream = null;
        try {
            String imagePath = request.getParameter("userImagePath");
            String usserGender = request.getParameter("gender").toLowerCase();
            File imageFile = new File(imagePath);
            if (!imageFile.exists()) {
                imagePath = imagePath.substring(0, imagePath.lastIndexOf("\\") + 1) + "user" + usserGender + ".jpeg";
                imageFile = new File(imagePath);
            }
            this.getFile(imageFile, response);

        } catch (Exception e) {
            e.getMessage();
        }
        return response;
    }

    private void getFile(File imageFile, HttpServletResponse response) throws Exception {
        if (imageFile.exists()) {
            response.setContentType("image/jpeg");
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpeg", outputStream);
            outputStream.close();
        }
    }

}
