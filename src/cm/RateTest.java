package cm;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class RateTest 
{	
	
	@Test(expected = IllegalArgumentException.class)
	public void reducedPeriodsNull()
	{
		Period[] newArray = {new Period(13, 16),new Period(17, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(10), BigDecimal.valueOf(5), null, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void normalPeriodsNull()
	{
		Period[] newArray = {new Period(13, 16),new Period(17, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(10), BigDecimal.valueOf(5),theReducedPeriods, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void normalRateNull()
	{
		Period[] newArray = {new Period(13, 16),new Period(17, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Rate theRate = new Rate(CarParkKind.STAFF, null, BigDecimal.valueOf(10), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ReducedRateNull()
	{
		Period[] newArray = {new Period(13, 16),new Period(17, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(10), null, theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	
	public void testReducedOverlap()
	{	
		Period[] array = {new Period(1, 6),new Period(5, 9)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(7, 12),new Period(13, 16)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNormalOverlap()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(14, 19)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testPeriodsOverlapEachother()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(5, 13),new Period(16, 19)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNormalRateLessThanZero()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(-1), BigDecimal.valueOf(0), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNomalRateLessThanZeroNonInteger()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(-0.1), BigDecimal.valueOf(0), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReducedRateLessThanZero()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(-1), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullCarkParkKind()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(null, BigDecimal.valueOf(5), BigDecimal.valueOf(-0.1), theReducedPeriods, theNormalPeriods);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReducedRateGreaterThanNormal()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(10), theReducedPeriods, theNormalPeriods);
	}
	
	@Test
	public void testNormalRateGreaterThanReduced()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(20), BigDecimal.valueOf(10), theReducedPeriods, theNormalPeriods);
	}
	
	@Test
	public void testNoOverlap()
	{	
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 17),new Period(18, 20)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(20), BigDecimal.valueOf(10), theReducedPeriods, theNormalPeriods);
	}
	
	@Test
	public void testCalculateNormalPeriod()
	{
		Period[] newArray = {new Period(13, 17),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(14, 16);
		assertEquals(BigDecimal.valueOf(10), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateFreePeriod()
	{
		Period[] array = {new Period(1, 6),new Period(7, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 16),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(17, 18);
		assertEquals(BigDecimal.valueOf(0), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateReducedPeriod()
	{
		Period[] array = {new Period(1, 6),new Period(9, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 16),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(2, 6);
		assertEquals(BigDecimal.valueOf(8), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateBothPeriods()
	{
		Period[] array = {new Period(1, 6),new Period(9, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 16),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(10, 14);
		assertEquals(BigDecimal.valueOf(9), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateFreeToNormalPeriod()
	{
		Period[] array = {new Period(1, 6),new Period(9, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(16, 23);
		assertEquals(BigDecimal.valueOf(20), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateFreeToReducedPeriod()
	{
		Period[] array = {new Period(1, 6),new Period(9, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(7, 12);
		assertEquals(BigDecimal.valueOf(6), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateAllThreePeriods()
	{
		Period[] array = {new Period(1, 6),new Period(9, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(7, 15);
		assertEquals(BigDecimal.valueOf(16), theRate.calculate(chargePeriod));
	}

	@Test
	public void testCalculateVisitor1()
	{
		Period[] array = {new Period(1, 6),new Period(9, 12)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(13, 15);
		assertEquals(BigDecimal.valueOf(1), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateVisitor2()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(9, 15);
		assertEquals(BigDecimal.valueOf(5), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateVisitor3()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(7, 20);
		assertEquals(BigDecimal.valueOf(7.5), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateVisitor4()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(7, 8);
		assertEquals(BigDecimal.valueOf(0), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateVisitor5()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(9, 13);
		assertEquals(BigDecimal.valueOf(0), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateManagement()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(6, 8);
		assertEquals(BigDecimal.valueOf(3), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateManagement2()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(5, 6);
		assertEquals(BigDecimal.valueOf(3), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateManagement3()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(19, 22);
		assertEquals(BigDecimal.valueOf(15), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateManagement4()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(6), BigDecimal.valueOf(1), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(9, 11);
		assertEquals(BigDecimal.valueOf(3), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateStudent()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(9, 11);
		assertEquals(BigDecimal.valueOf(4), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateStudent2()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(13, 14);
		assertEquals(BigDecimal.valueOf(5), theRate.calculate(chargePeriod));
	}
	
	@Test
	public void testCalculateStudent3()
	{
		Period[] array = {new Period(1, 6),new Period(9, 13)};
		ArrayList<Period> theReducedPeriods = new ArrayList<Period>(Arrays.asList(array));
		Period[] newArray = {new Period(13, 15),new Period(19, 23)};
		ArrayList<Period> theNormalPeriods = new ArrayList<Period>(Arrays.asList(newArray));
		Rate theRate = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), theReducedPeriods, theNormalPeriods);
		Period chargePeriod = new Period(6, 21);
		assertEquals(BigDecimal.valueOf(7), theRate.calculate(chargePeriod));
	}
}