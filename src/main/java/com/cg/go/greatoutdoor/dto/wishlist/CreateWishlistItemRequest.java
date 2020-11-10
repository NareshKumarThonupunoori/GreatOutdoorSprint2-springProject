package com.cg.go.greatoutdoor.dto.wishlist;



public class CreateWishlistItemRequest {
//	@NotBlank @Size(min =2, max = 20)
	private Integer wishlistId;
	//@NotBlank @Size(min =2, max = 20)
    private int userId;
  //  @ElementCollection
   // @NotBlank @Size(min =2, max = 20)
   // private List<String> productId;
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
/*	public List<String> getProductId() {
		return productId;
	}
	public void setProductId(List<String> productId) {
		this.productId = productId;
	}
}*/