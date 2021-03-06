package me.monetor.gmail.api.response;

import java.util.List;

public class MessageResponse {
	
	private String threadId;
	private Payload payload;
	
	public class Payload{
		private List<Parts> parts;
		private Body body;

		public List<Parts> getParts() {
			return parts;
		}

		public void setParts(List<Parts> parts) {
			this.parts = parts;
		}

		public Body getBody() {
			return body;
		}

		public void setBody(Body body) {
			this.body = body;
		}

		@Override
		public String toString() {
			return "Payload [parts=" + parts + ", body=" + body + "]";
		}
		
		
		
	}
	
	public class Parts{
		private Body body;

		public Body getBody() {
			return body;
		}

		public void setBody(Body body) {
			this.body = body;
		}

		@Override
		public String toString() {
			return "Parts [body=" + body + "]";
		}
		
		
	}
	
	public class Body{
		private String data;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Body [data=" + data + "]";
		}
		
		
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "MessageResponse [threadId=" + threadId + ", payload=" + payload + "]";
	}
	
	
	
}
