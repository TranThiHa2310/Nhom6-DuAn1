/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.view;

import app.dao.KhachHangDao;
import app.dbconnect.DialogHelper;
import app.model.KhachHang;
import app.service.KhachHangService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CustomerPanel extends javax.swing.JPanel {

    KhachHangService service = new KhachHangService();

    KhachHangDao khdao = new KhachHangDao();
    private List<KhachHang> lst = new ArrayList<>();
    int id;

    public CustomerPanel() {
        initComponents();
        loadTable();
    }

    private void loadTable() {
        int stt = 1;
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        for (KhachHang kh : khdao.getAll()) {

            Object[] row = {
                stt,
                kh.getMaKH(),
                kh.getTen(),
                kh.getSdt(),
                kh.getDiaChi(),
                kh.isGioiTinh() ? "Nam" : "Nữ",};
            model.addRow(row);
            stt++;

        }

    }

    public void show(int index) {
        KhachHang s = khdao.getAll().get(index);
        txtMa.setText(s.getMaKH());
        txtTen.setText(s.getTen());
        txtSdt.setText(s.getSdt());
        txtDiaChi.setText(s.getDiaChi());

        if (s.isGioiTinh() == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);

        }

    }

    public void clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSdt.setText("");
        rdoNam.setSelected(true);

    }

    public KhachHang getForm() {

        String ma = txtMa.getText().trim();
        String tenn = txtTen.getText().trim();
        String sdttt = txtSdt.getText().trim();
        String diaChiii = txtDiaChi.getText().trim();
        boolean gioiTinhh = true;
        

        if (ma.length() == 0 || tenn.length() == 0 || sdttt.length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền thông tin không được để trống!!!");
            return null;
        }
        KhachHang s = new KhachHang(ma, tenn, sdttt, diaChiii, gioiTinhh);
        return s;

    }

    void timMa() {
        DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang.getModel();
        tblModel.setRowCount(0);
        int stt = 1;
        try {
            String keyword = txtTimKiem.getText();
            List<KhachHang> lstNV = khdao.timKiem(keyword, keyword, keyword);
            for (KhachHang x : lstNV) {

                Object[] row = {
                    stt,
                    x.getMaKH(),
                    x.getTen(),
                    x.getSdt(),
                    x.getDiaChi(),
                    x.isGioiTinh() ? "Nam" : "Nữ",};
                tblModel.addRow(row);
                stt++;
            }
        } catch (Exception e) {
            e.printStackTrace();

            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }

    void loadLichSu() {
        DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang1.getModel();
        tblModel.setRowCount(0);
        int stt = 1;
        try {
            String MaKH = (String) tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 1);
            List<KhachHang> lstNV = khdao.lichSu(MaKH);
            for (KhachHang x : lstNV) {
                Object[] row = {
                    stt,
                    x.getMaHD(),
                    x.getMaKH(),
                    x.getTen(),
                    x.getSdt(),
                    x.getDiaChi(),
                    x.getNgayGiaoDich(),
                    x.getTongTien(),
                    x.getTrangThai1() == 1 ? "da thanh toan" : "chua thanh toan",};

                tblModel.addRow(row);
                stt++;

            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Lỗi");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelCustomerInfor = new javax.swing.JPanel();
        btnXoa = new app.view.swing.ButtonGradient();
        labelNameError = new javax.swing.JLabel();
        labelPhoneNumberError = new javax.swing.JLabel();
        labelEmailError = new javax.swing.JLabel();
        labelAddressError = new javax.swing.JLabel();
        labelDateError = new javax.swing.JLabel();
        labelNameError1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        btnLamMoi = new app.view.swing.ButtonGradient();
        txtTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        btnUpdate2 = new app.view.swing.ButtonGradient();
        btnAdd = new app.view.swing.ButtonGradient();
        panelListCustomer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new app.view.swing.ButtonGradient();
        tab2 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang1 = new javax.swing.JTable();
        labelPanelCustomer = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelCustomerInfor.setBackground(new java.awt.Color(255, 255, 255));
        panelCustomerInfor.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Khách Hàng"));

        btnXoa.setText("Xóa");
        btnXoa.setColor2(new java.awt.Color(23, 35, 51));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        labelNameError.setForeground(new java.awt.Color(255, 0, 51));
        labelNameError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelPhoneNumberError.setForeground(new java.awt.Color(255, 0, 51));
        labelPhoneNumberError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelEmailError.setForeground(new java.awt.Color(255, 0, 51));
        labelEmailError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelAddressError.setForeground(new java.awt.Color(255, 0, 0));
        labelAddressError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelDateError.setForeground(new java.awt.Color(255, 0, 51));
        labelDateError.setPreferredSize(new java.awt.Dimension(0, 14));

        labelNameError1.setForeground(new java.awt.Color(255, 0, 51));
        labelNameError1.setPreferredSize(new java.awt.Dimension(0, 14));

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.setColor2(new java.awt.Color(23, 35, 51));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã KH");

        jLabel2.setText("Họ và tên");

        jLabel3.setText("Số điện thoại ");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Địa chỉ");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnUpdate2.setText("Sửa");
        btnUpdate2.setColor2(new java.awt.Color(23, 35, 51));
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.setColor2(new java.awt.Color(23, 35, 51));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCustomerInforLayout = new javax.swing.GroupLayout(panelCustomerInfor);
        panelCustomerInfor.setLayout(panelCustomerInforLayout);
        panelCustomerInforLayout.setHorizontalGroup(
            panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(labelNameError1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelDateError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createSequentialGroup()
                                    .addComponent(labelNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79)))))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(30, 30, 30))))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelAddressError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(txtDiaChi))
                .addGap(110, 110, 110)
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPhoneNumberError, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(153, 153, 153))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCustomerInforLayout.setVerticalGroup(
            panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerInforLayout.createSequentialGroup()
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(labelPhoneNumberError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(labelNameError1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(7, 7, 7)
                .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(labelAddressError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerInforLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5))
                            .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(labelNameError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelCustomerInforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(7, 7, 7)
                        .addComponent(labelDateError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCustomerInforLayout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelListCustomer.setBackground(new java.awt.Color(255, 255, 255));
        panelListCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Khách Hàng"));

        jLabel6.setText("Tìm kiếm");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setColor2(new java.awt.Color(23, 35, 51));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Họ và tên", "Số điện thoại ", "Địa chỉ", "Giới tính"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        tab2.addTab("Danh sách khách hàng", jScrollPane2);

        tblKhachHang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Mã KH", "Tên KH", "SĐT", "Địa chỉ", "Ngày hoàn thành", "Tổng tiền ", "Trạng thái"
            }
        ));
        jScrollPane3.setViewportView(tblKhachHang1);

        tab2.addTab("Lịch sử mua hàng", jScrollPane3);

        javax.swing.GroupLayout panelListCustomerLayout = new javax.swing.GroupLayout(panelListCustomer);
        panelListCustomer.setLayout(panelListCustomerLayout);
        panelListCustomerLayout.setHorizontalGroup(
            panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelListCustomerLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(56, 56, 56)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelListCustomerLayout.setVerticalGroup(
            panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListCustomerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelListCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        labelPanelCustomer.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        labelPanelCustomer.setForeground(new java.awt.Color(51, 102, 255));
        labelPanelCustomer.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(580, 580, 580)
                                .addComponent(labelPanelCustomer))
                            .addComponent(panelListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelCustomerInfor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCustomerInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhachHang s = getForm();
        if (s != null) {
            try {
                if (JOptionPane.showConfirmDialog(this, "Xac Nhan Them", "XacNhan", JOptionPane.YES_NO_OPTION) == 0) {
                    service.them(s);
                    loadTable();
                    JOptionPane.showMessageDialog(this, "Them thanh cong");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Them that bai");
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, 3);
        if (confirm == JOptionPane.YES_OPTION) {
            String makh = txtMa.getText();
            try {
                khdao.deleteNV(makh);
                this.clear();
                loadTable();
                DialogHelper.alert(this, "Xóa thành công!!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại!!");
            }
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed

    }//GEN-LAST:event_txtMaActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed

        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa không?", "Thông báo!", JOptionPane.YES_NO_CANCEL_OPTION, 3);
        if (confirm == JOptionPane.YES_OPTION) {
            KhachHang model = getForm();
            String ma = txtMa.getText();
            try {
                if (txtMa.getText().equals(ma)) {
                    khdao.updateNV(model);
                    loadTable();
                    DialogHelper.alert(this, "Cập nhật thành công");

                }

            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
            }
        }
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        this.timMa();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked

    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
       id = tblKhachHang.getSelectedRow();
        show(id);
         if (evt.getClickCount() == 1) {
            this.id = tblKhachHang.rowAtPoint(evt.getPoint());
            if (this.id >= -1) {

                this.loadLichSu();
            }
        } else {
            id = tblKhachHang.getSelectedRow();
            this.show(id);
         }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.view.swing.ButtonGradient btnAdd;
    private app.view.swing.ButtonGradient btnLamMoi;
    private app.view.swing.ButtonGradient btnTimKiem;
    private app.view.swing.ButtonGradient btnUpdate2;
    private app.view.swing.ButtonGradient btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAddressError;
    private javax.swing.JLabel labelDateError;
    private javax.swing.JLabel labelEmailError;
    private javax.swing.JLabel labelNameError;
    private javax.swing.JLabel labelNameError1;
    private javax.swing.JLabel labelPanelCustomer;
    private javax.swing.JLabel labelPhoneNumberError;
    private javax.swing.JPanel panelCustomerInfor;
    private javax.swing.JPanel panelListCustomer;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTabbedPane tab2;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblKhachHang1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
