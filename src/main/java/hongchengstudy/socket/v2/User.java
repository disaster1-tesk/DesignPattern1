package hongchengstudy.socket.v2;


/**
 * Created by littlecurl 2018/6/24
 */
public class User {
	private String name;            //用户名
	private server.Mychannel channel;        //密码
	public User(server.Mychannel channel, String name) {
		this.channel = channel;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public server.Mychannel getChannel() {
		return channel;
	}

	public void setChannel(server.Mychannel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", password='" + channel + '\'' +
				'}';
	}
}

