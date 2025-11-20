const sidebarData = [
  {
    key: "tongQuan",
    title: "Bán hàng tại quầy",
    icon: "fa-solid fa-store",
    path: "/admin/order",
  },
  {
    key: "qlDonHang",
    title: "Quản lý hoá đơn",
    icon: "fa-solid fa-receipt",
    path: "/admin/bill",
  },

  {
    key: "qlsanpham",
    title: "Quản lý sản phẩm",
    icon: "fa-solid fa-box-open",
    path: "/services",
    children: [
      {
        key: "sanPham",
        title: "Sản phẩm",
        icon: "fa-solid fa-shirt",
        path: "/admin/product",
      },
      {
        key: "kichCo",
        title: "Kích cỡ",
        icon: "fa-solid fa-ruler",
        path: "/admin/size",
      },
      {
        key: "mauSac",
        title: "Màu sắc",
        icon: "fa-solid fa-droplet",
        path: "/admin/color",
      },
      {
        key: "thuongHieu",
        title: "Thương hiệu",
        icon: "fa-solid fa-star",
        path: "/admin/brand",
      },
      {
        key: "chatLieu",
        title: "Chất liệu",
        icon: "fa-solid fa-layer-group",
        path: "/admin/material",
      },
      {
        key: "xuatXu",
        title: "Xuất xứ",
        icon: "fa-solid fa-earth-asia",
        path: "/admin/origin",
      },

      {
        key: "tayAo",
        title: "Tay áo",
        icon: "fa-solid fa-hand",
        path: "/admin/sleeve",
      },
      {
        key: "coAo",
        title: "Cổ áo",
        icon: "fa-solid fa-shirt",
        path: "/admin/collar",
      },
    ],
  },
  {
    key: "qlTaiKhoan",
    title: "Quản lý tài khoản",
    icon: "fa-solid fa-user-gear",
    children: [
      {
        key: "qlNhanVien",
        title: "Quản lý nhân viên",
        icon: "fa-solid fa-user-tie",
        path: "/admin/staff",
      },
      {
        key: "qlKhachHang",
        title: "Quản lý khách hàng",
        icon: "fa-solid fa-user-group",
        path: "/admin/customer",
      },
    ],
  },
  {
    key: "qlKhuyenMai",
    title: "Quản lý khuyến mãi",
    icon: "fa-solid fa-tags",
    children: [
      {
        key: "qlVoucher",
        title: "Quản lý phiếu giảm giá",
        icon: "fa-solid fa-tags",
        path: "/admin/voucher",
      },
    ],
  },
];

export default sidebarData;
