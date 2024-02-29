# DoAnJava
# <h1 align="center">Ricon<h1>

  
<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="">
  </a>

  <p align="center">
    Hệ thống quản lý bán hàng điện thoại di động
    <br />
    <a href="https://github.com/shenkedokato/Java"><strong>Khám phá »</strong></a>
    <br />
    <br />
  </p>
</div>

  
  
  <!-- TABLE OF CONTENTS -->
<details>
  <summary>Mục lục</summary>
  <ol>
    <li>
      <a href="#muctieu">Mục tiêu đồ án</a>
    </li>
    <li>
      <a href="#dsthanhvien">Danh sách thành viên</a>
    </li>
    <li><a href="#thuvien">Các thư viện</a></li>
    <li>
      <a href="#chucnang">Các chức năng</a>
    </li>
    <li><a href="#yeucau">Yêu cầu hệ thống</a></li>
    </li>
    <li><a href="#thamkhao">Tài liệu tham khảo</a></li>
  </ol>
</details>
  
## Directory structure
```
----Java
    |---.github
    |   |---workflow
    |---Đồ án
    |   |---Library
    |   |---Phân tích thiết kế
    |   |---Script
    |---Lab
    |---Seminar
    |---README

```
  
  <!-- ABOUT THE PROJECT -->
## <h2 id="muctieu">Mục tiêu của đồ án</h2>
Đáp ứng được yêu cầu xây dựng một ứng dụng quản lý cửa hàng bán điện thoại di động với các yêu cầu chặt chẽ và thuyết phục sau:
- Mục tiêu của ứng dụng là quản lý thông tin khách hàng và nhà cung cấp một cách hiệu quả và nhanh chóng. 
- Cập nhật thông tin sản phẩm xuất nhập mỗi ngày, cập nhật tình hình doanh số và số liệu sản phẩm trong kho.
- Đơn giản hóa quá trình mua bán sản phẩm online, quản lý phản hồi và đóng góp ý kiến của khách hàng, kết hợp với các sự kiện khuyến mãi giúp khách hàng hiểu rõ hơn về chương trình áp dụng.
- Quản lý thông tin bảo hành và giao dịch của khách hàng, quản lý tình hình nhân viên và cập nhật thông tin sản phẩm cần nhập hàng và tiền hàng nhập sản phẩm. 

Với các yêu cầu đề xuất trên là mục tiêu trong phần mềm quản lý đối với cửa hàng bán điện thoại di động. Khi áp dụng vào thực tiễn ứng dụng sẽ giảm thiểu việc sử dụng các phương pháp thủ công và làm hiện đại hóa quá trình mua bán giữa khách hàng và nhà sản xuất, giúp tiếp cận khách hàng một cách hiệu quả và tiết kiệm thời gian thông qua việc truy cập vào ứng dụng.
## <h2 id="dsthanhvien">Các thành viên tham gia project</h2>
 
| STT| Họ tên                  | MSSV     |     Nhiệm vụ     |   Đánh giá % |
|:--:|-------------------      |----------|------------------|--------------|
| 1  | Trần Minh Quân          | 21520414 |                  |              |
| 2  | Ngô Tất Tố              | 21520484 |                  |              | 
| 3  | Lê Xuân Thạch           | 21521421 |                  |              |
| 4  | Nguyễn Nhật Phương Huy  | 21522156 |                  |              |
  

### Nhiệm vụ, đánh giá và công việc cụ thể sẽ được thêm vào và đánh giá sau khi dự án hoàn thành
  
### <h2 id="thuvien">Các thư viện sử dụng</h2>

Hệ thống được xây dựng dựng bởi các công cụ hiện đại:
- [Java Swing](https://netbeans.apache.org/kb/docs/java/quickstart-gui.html)
  
  
# <h2 id="chucnang">Tóm tắt chức năng</h2>
- Quản lý sẽ được cấp mục sau:<br/>
  Thêm, sửa, xóa, tra cứu các mục sau:
  + Quản lý sản phẩm 
  + Quản lý khách hàng
  + Quản lý khà cung cấp
  + Quản lý bán hàng
  + Quản lý khuyến mãi
  + Quản lý nhân viên
  + Quản lý phòng ban
  + Thông kê doanh thu <br/>
- Thống kê doanh thu:<br/>
  + Xuất thông tin báo cáo theo năm,tháng,ngày<br/>
- Nhân viên sẽ được cấp mục sau:
  + Quản lý sản phẩm (<b>thêm, xoá, sửa, tra cứu</b>)
  + Quản lý khách hàng (<b>thêm, xoá, sửa, tra cứu</b>)
  + Quản lý nhà cung cấp (<b>thêm, xoá, sửa, tra cứu</b>)
  + Quản lý bán hàng (<b>thêm, xoá, sửa, tra cứu</b>)
  + Quản lý khuyến mãi (<b>thêm, xoá, sửa, tra cứu</b>)
- Tạo account tương ứng cho quản lý, nhân viên và tự động phân quyền theo các role đã được định sẵn. 
- Xuất file excel cho khách hàng và nhân viên.<br/>

  
  
 # <h2 id="yeucau">Yêu cầu hệ thống:</>
- NetBeans IDE 13 (<b>có thể sử dụng các phiên bản khác</b>)
- Oracle Database 19c (<b>có thể sử dụng các phiên bản khác</b>)
  


# <h2 id="thamkhao">Tài liệu tham khảo</h2> 
1. [Tài liệu Oracle của hãng Oracle](https://docs.oracle.com/en/database/oracle/oracle-database/index.html)
2. [Tài liệu về Java, Java Swing](https://docs.oracle.com/javase/tutorial/)
