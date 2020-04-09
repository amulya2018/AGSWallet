package AccntBean;

public class Transactions {
		private String userId;
		private double amount;
		private String transType; String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getTransType() {
			return transType;
		}
		public void setTransType(String transType) {
			this.transType = transType;
		}
		@Override
		public String toString() {
			return "Transactions [userId=" + userId + ", amount=" + amount + ", transType=" + transType + "]";
		}

}
