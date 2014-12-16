# Implementasi Liferay
### Testimony/Chat Widget

Dalam rangka kuliah IF4050, kami mengimplementasikan plugin Liferay yang berfungsi untuk menyimulasikan fungsi-fungsi primitif chatting widget menggunakan Liferay portlet (portal applet).

# Overview
Aplikasi chatting yang dibuat akan mengakses database MySQL menggunakan API yang digenerate oleh Liferay Service Builder untuk entity yang dibuat pada portlet ini, yaitu entity **Message**. Operasi-operasi yang dapat dilakukan pada portlet ini antara lain adalah:

- Add Message
- View Message

# Requirements
1. Liferay IDE Eclipse for Windows
2. Liferay Portal 6.2
3. Liferay Plugin SDK 6.0

# Steps
1. Install Liferay
2. Konfigurasi Database
 - Untuk mengkonfigurasi database yang digunakan oleh Liferay, ubahlah file konfigurasi `portal-ext.properties` pada folder `${CATALINA_HOME}/webapps/ROOT/WEB-INF/classes` 
 - Bila file tersebut belum ada, buatlah dan isi dengan konfigurasi berikut:
 ```
 jdbc.default.driverClassName=com.mysql.jdbc.Driver
 jdbc.default.url=jdbc:mysql://localhost/lportal?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
 jdbc.default.username=root
 jdbc.default.password=
  ``` 
 Dimana `lportal` adalah nama database MySQL yang digunakan. Bila belum ada, buat database tersebut juga.
3. Di Liferay IDE, buatlah sebuah `Liferay Plugin Project` dan `Portlet Project`-nya.
4. Gunakan `Liferay Service Builder` untuk membuat model yang akan dibuat servicenya, dalam hal ini model **Message**. `Liferay Service Builder` akan men-generate file `service.xml` yang menjadi definisi model Message tersebut. Ubah agar model tersebut memiliki atribut berikut: 

 ```
 <entity name="Message" local-service="true" remote-service="true">
	<!-- PK fields -->
	<column name="messageId" type="long" primary="true" />
	<!-- Audit fields -->
	<column name="userName" type="String" />
	<column name="content" type="String" />
 </entity>
  ```
 Dimana `userName` menunjukkan nama orang yang melakukan chat dan `content` menunjukkan konten dari pesan yang dikirim.

5. Pada file `service.xml`, pindah ke mode *Overview*, dan pada pojok kanan atas tekan tombol **Build Services**, lalu akan ter-generate kerangka-kerangka file Java yang harus kita implementasikan.

6. Dalam pengembangan *service* pada Liferay, Liferay menyediakan kelas bawaan `{nama_model}LocalServiceUtil` untuk memudahkan pengembangan *service* yang akan kita buat. Sehingga dalam kasus kita, kita dapat mengakses method-method kelas `MessageLocalServiceUtil` untuk mempermudah pengembangan, seperti `addMessage(Message m)`, `getMessages(int start, int end)`, dan lain-lain. 

 Namun, kita akan membuat method baru dikelas `MessageLocalServiceUtil` tersebut dengan parameter yang lebih sesuai. Hal tersebut dapat dicapai dengan menambahkan method baru di kelas `MessageLocalServiceImpl.java` yang telah digenerate oleh `Liferay Service Builder` tadi.

 Tambahkan dua *method* berikut ke dalam `MessageLocalServiceImpl.java`:
 ```
public void addMessage(String name, String content){
		try {
			Message message = createMessage(CounterLocalServiceUtil.increment());
			message.setUserName(name);
			message.setContent(content);
			addMessage(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Message> getMessages(){
		List<Message> messages = null;
		try {
			messages = getMessages(0, getMessagesCount());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return messages;
	}
 ```
Pada method `addMessage` kita menggunakan method `increment()` dari kelas `CounterLocalServiceUtil` untuk mendapatkan *primary key* dari *object* yang akan kita buat. Kedua method tersebut digunakan untuk mengakses model Message yang sudah kita buat. 

 Untuk menggunakan method tersebut lewat kelas `MessageLocalServiceUtil`, kita harus melakukan build ulang file `service.xml` terlebih dahulu, dengan langkah yang sama seperti diatas. Setelah itu, method tersebut siap untuk digunakan.

 Contoh penggunaannya pada *portlet controller*:  
 ```
 String name = actionRequest.getParameter("name");
 String msg = actionRequest.getParameter("msg");
 
 MessageLocalServiceUtil.addMessage(name, msg); 
 ```

 Contoh penggunaannya pada *view*:
 ```
 <%
	List<Message> messages = MessageLocalServiceUtil.getMessages();
 %>
 <div style="height:250px;overflow-y:auto;">
	<% 
		for(Message m: messages){
			out.println("<div>");
			out.println("<h5 style=\"margin-bottom:0px;\">" + m.getUserName() + "</h5>");
			out.println("<p style=\"margin-left:15px;\">"+ m.getContent() +"</p>");
			out.println("</div>");
		}
	%>
</div>
 ```

# Screenshots

![Screenshot portlet](http://i.imgur.com/PGYQN9q.png "Screenshot portlet")

![Screenshot database data](http://i.imgur.com/a1g6DOc.png "Screenshot database data")

# Team Members

- Alif Raditya Rochman - **13511013@std.stei.itb.ac.id**
- Fathan Adi Pranaya - **13511011@std.stei.itb.ac.id**
- Sonny Lazuardi Hermawan - **13511030@std.stei.itb.ac.id**
- Muhammad Harits Shalahuddin Adil Haqqi Elfahmi - **13511046@std.stei.itb.ac.id**
