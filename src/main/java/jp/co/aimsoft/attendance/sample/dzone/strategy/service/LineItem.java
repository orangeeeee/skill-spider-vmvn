package jp.co.aimsoft.attendance.sample.dzone.strategy.service;

/**
 * 単一アイテム
 * <p>
 * 請求書の１行分
 * </p>
 */
public class LineItem {

	// 説明
	private String description;
	// コスト (cent)
	private int costInCents;

	public LineItem(String description, int costInCents) {
		this.description = description;
		this.costInCents = costInCents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCostInCents() {
		return costInCents;
	}

	public void setCostInCents(int costInCents) {
		this.costInCents = costInCents;
	}
}
