package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import java.sql.ResultSet;



import db.DBCONNECTION;
import thirdparty.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
		boolean login = false;
		String emailString;
		String type;
		Connection con;
		
		try {
			con = DBCONNECTION.initializeDatabase();
			String NIC = request.getParameter("NIC");
			//String password = request.getParameter("password");
			System.out.println(NIC );
			PreparedStatement st = con.prepareStatement("Select * from Person where NIC = ?");
			st.setString(1, NIC);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				login = true;
				 emailString = rs.getString("email");
				 type = rs.getString("type");
				 
				 if (login == true) {
						PinGenarate pin = new PinGenarate();
						pin.setGenarate(true);
						int pinnumber = pin.getRandom();
						
						String to= emailString;  
					    String subject="otp";  
					    String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html dir=\"ltr\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\"><head><meta charset=\"UTF-8\"><meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"><meta name=\"x-apple-disable-message-reformatting\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta content=\"telephone=no\" name=\"format-detection\"><title>New Template</title> <!--[if (mso 16)]><style type=\"text/css\">     a {text-decoration: none;}     </style><![endif]--> <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> <!--[if gte mso 9]><xml> <o:OfficeDocumentSettings> <o:AllowPNG></o:AllowPNG> <o:PixelsPerInch>96</o:PixelsPerInch> </o:OfficeDocumentSettings> </xml>\r\n"
					    		+ "<![endif]--><style type=\"text/css\">#outlook a { padding:0;}.es-button { mso-style-priority:100!important; text-decoration:none!important;}a[x-apple-data-detectors] { color:inherit!important; text-decoration:none!important; font-size:inherit!important; font-family:inherit!important; font-weight:inherit!important; line-height:inherit!important;}.es-desk-hidden { display:none; float:left; overflow:hidden; width:0; max-height:0; line-height:0; mso-hide:all;}@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120%!important } h1 { font-size:36px!important; text-align:left } h2 { font-size:26px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:36px!important; text-align:left }\r\n"
					    		+ " .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:26px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:12px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important }\r\n"
					    		+ " .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:20px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0!important } .es-m-p0r { padding-right:0!important } .es-m-p0l { padding-left:0!important } .es-m-p0t { padding-top:0!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important }\r\n"
					    		+ " tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-m-p5 { padding:5px!important } .es-m-p5t { padding-top:5px!important } .es-m-p5b { padding-bottom:5px!important } .es-m-p5r { padding-right:5px!important } .es-m-p5l { padding-left:5px!important } .es-m-p10 { padding:10px!important } .es-m-p10t { padding-top:10px!important } .es-m-p10b { padding-bottom:10px!important } .es-m-p10r { padding-right:10px!important }\r\n"
					    		+ " .es-m-p10l { padding-left:10px!important } .es-m-p15 { padding:15px!important } .es-m-p15t { padding-top:15px!important } .es-m-p15b { padding-bottom:15px!important } .es-m-p15r { padding-right:15px!important } .es-m-p15l { padding-left:15px!important } .es-m-p20 { padding:20px!important } .es-m-p20t { padding-top:20px!important } .es-m-p20r { padding-right:20px!important } .es-m-p20l { padding-left:20px!important } .es-m-p25 { padding:25px!important } .es-m-p25t { padding-top:25px!important } .es-m-p25b { padding-bottom:25px!important } .es-m-p25r { padding-right:25px!important } .es-m-p25l { padding-left:25px!important } .es-m-p30 { padding:30px!important } .es-m-p30t { padding-top:30px!important } .es-m-p30b { padding-bottom:30px!important } .es-m-p30r { padding-right:30px!important } .es-m-p30l { padding-left:30px!important } .es-m-p35 { padding:35px!important } .es-m-p35t { padding-top:35px!important }\r\n"
					    		+ " .es-m-p35b { padding-bottom:35px!important } .es-m-p35r { padding-right:35px!important } .es-m-p35l { padding-left:35px!important } .es-m-p40 { padding:40px!important } .es-m-p40t { padding-top:40px!important } .es-m-p40b { padding-bottom:40px!important } .es-m-p40r { padding-right:40px!important } .es-m-p40l { padding-left:40px!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }@media screen and (max-width:384px) {.mail-message-content { width:414px!important } }</style>\r\n"
					    		+ " </head> <body data-new-gr-c-s-loaded=\"14.1147.0\" style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"><div dir=\"ltr\" class=\"es-wrapper-color\" lang=\"en\" style=\"background-color:#FAFAFA\"> <!--[if gte mso 9]><v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\"> <v:fill type=\"tile\" color=\"#fafafa\"></v:fill> </v:background><![endif]--><table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#FAFAFA\"><tr>\r\n"
					    		+ "<td valign=\"top\" style=\"padding:0;Margin:0\"><table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"><tr><td class=\"es-info-area\" align=\"center\" style=\"padding:0;Margin:0\"><table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" bgcolor=\"#FFFFFF\"><tr><td align=\"left\" style=\"padding:20px;Margin:0\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr>\r\n"
					    		+ "<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr><td align=\"center\" class=\"es-infoblock\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#CCCCCC;font-size:12px\">View online version</a></p> </td></tr></table></td></tr></table></td></tr></table></td></tr></table>\r\n"
					    		+ " <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"><tr><td align=\"center\" style=\"padding:0;Margin:0\"><table bgcolor=\"#ffffff\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"><tr><td align=\"left\" style=\"padding:20px;Margin:0\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr>\r\n"
					    		+ "<td class=\"es-m-p0r\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr><td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:10px;font-size:0px\"><img src=\"https://ecdeqik.stripocdn.email/content/guids/CABINET_94a7abc5c174ae0e09bfa3c4e9a8bf12d8edb6e7995a9007d9b03c726c8b6a24/images/asset1.png\" alt=\"Logo\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;font-size:12px\" width=\"200\" title=\"Logo\"></td> </tr></table></td></tr></table></td></tr></table></td></tr></table> <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"><tr>\r\n"
					    		+ "<td align=\"center\" style=\"padding:0;Margin:0\"><table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"><tr><td align=\"left\" style=\"padding:0;Margin:0;padding-top:15px;padding-left:20px;padding-right:20px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr><td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr>\r\n"
					    		+ "<td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;font-size:0px\"><img src=\"https://ecdeqik.stripocdn.email/content/guids/CABINET_91d375bbb7ce4a7f7b848a611a0368a7/images/69901618385469411.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"100\"></td> </tr><tr><td align=\"center\" class=\"es-m-p0r es-m-p0l es-m-txt-c\" style=\"Margin:0;padding-top:15px;padding-bottom:15px;padding-left:40px;padding-right:40px\"><h1 style=\"Margin:0;line-height:55px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:46px;font-style:normal;font-weight:bold;color:#333333\">Password reset&nbsp;</h1></td></tr><tr>\r\n"
					    		+ "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">After you enterd the pin, you'll be asked to complete the following steps:</p> <ol><li style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;Margin-bottom:15px;margin-left:0;color:#333333;font-size:14px\">Enter a new password.</li><li style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;Margin-bottom:15px;margin-left:0;color:#333333;font-size:14px\">Click Submit.</li></ol></td></tr><tr>\r\n"
					    		+ "<td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"><h2 style=\"Margin:0;line-height:23px;mso-line-height-rule:exactly;font-family:verdana, geneva, sans-serif;font-size:19px;font-style:normal;font-weight:bold;color:#0d6c5f\"><strong>"+pinnumber+"</strong></h2></td></tr></table></td></tr></table></td></tr> <tr><td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:20px;padding-left:20px;padding-right:20px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr><td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-radius:5px\"><tr>\r\n"
					    		+ "<td align=\"center\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-top:10px\"><h3 style=\"Margin:0;line-height:30px;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:20px;font-style:normal;font-weight:bold;color:#333333\">This link is valid for one use only. Expires immediately after enter.</h3></td></tr> <tr><td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#333333;font-size:14px\">If you didn't request to reset your&nbsp;password, please disregard this message or contact our customer service department.</p></td></tr></table></td></tr></table></td></tr></table></td></tr></table>\r\n"
					    		+ " <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\"><tr><td align=\"center\" style=\"padding:0;Margin:0\"><table class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\"><tr><td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr>\r\n"
					    		+ "<td align=\"left\" style=\"padding:0;Margin:0;width:560px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr><td align=\"center\" style=\"padding:0;Margin:0;padding-top:15px;padding-bottom:15px;font-size:0\"><table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr><td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:40px\"><img title=\"Facebook\" src=\"https://ecdeqik.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
					    		+ " <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:40px\"><img title=\"Twitter\" src=\"https://ecdeqik.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td><td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:40px\"><img title=\"Instagram\" src=\"https://ecdeqik.stripocdn.email/content/assets/img/social-icons/logo-black/instagram-logo-black.png\" alt=\"Inst\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\r\n"
					    		+ " <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><img title=\"Youtube\" src=\"https://ecdeqik.stripocdn.email/content/assets/img/social-icons/logo-black/youtube-logo-black.png\" alt=\"Yt\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td></tr></table></td></tr><tr><td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:35px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#333333;font-size:12px\">Green superIt © 2021 Green superIt, Inc. All Rights Reserved.</p>\r\n"
					    		+ " <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#333333;font-size:12px\">4562 Green supermarket Limits, Chair Crossing, Kentucky, US, 607898</p></td></tr><tr><td style=\"padding:0;Margin:0\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr class=\"links\"><td align=\"center\" valign=\"top\" width=\"33.33%\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:5px;padding-bottom:5px;border:0\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#333333;font-size:12px\">Visit Us </a></td>\r\n"
					    		+ " <td align=\"center\" valign=\"top\" width=\"33.33%\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:5px;padding-bottom:5px;border:0;border-left:1px solid #cccccc\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#333333;font-size:12px\">Privacy Policy</a></td><td align=\"center\" valign=\"top\" width=\"33.33%\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:5px;padding-bottom:5px;border:0;border-left:1px solid #cccccc\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#333333;font-size:12px\">Terms of Use</a></td></tr></table></td></tr></table></td></tr> </table></td></tr></table>\r\n"
					    		+ "</td></tr></table> <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"><tr><td class=\"es-info-area\" align=\"center\" style=\"padding:0;Margin:0\"><table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" bgcolor=\"#FFFFFF\"><tr><td align=\"left\" style=\"padding:20px;Margin:0\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr>\r\n"
					    		+ "<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"><tr>\r\n"
					    		+ "<td align=\"center\" class=\"es-infoblock\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#CCCCCC;font-size:12px\"></a>No longer want to receive these emails?&nbsp;<a href=\"\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#CCCCCC;font-size:12px\">Unsubscribe</a>.<a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#CCCCCC;font-size:12px\"></a></p> </td></tr></table></td>\r\n"
					    		+ "</tr></table></td></tr></table></td></tr></table></td></tr></table></div></body></html>";  
					          
					    Mailverification.send(to, subject, msg, true); 
					    HttpSession session = request.getSession();
					    session.setAttribute("email", emailString );
					    session.setAttribute("pin", pinnumber);
					    session.setAttribute("nic", NIC);	
					    session.setAttribute("type", type);
					    RequestDispatcher requestDispatcher = 
	 		 	    			request.getRequestDispatcher("/otpenter.jsp");
	 		 			requestDispatcher.forward(request, response);
					    
						}
				 
				 
				 
			}
			
			if (login != true) {
				
				request.setAttribute("validity", "false");
 				RequestDispatcher requestDispatcher = 
		 	    			request.getRequestDispatcher("/Login.jsp");
		 			requestDispatcher.include(request, response);
			}
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
