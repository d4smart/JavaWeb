package stuPackage;

// 找不到数据异常
public class NotFoundException extends Exception
{
	public NotFoundException(String message)
	{
		super(message);
	}
}
