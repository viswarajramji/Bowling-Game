import org.junit.Assert;
import org.junit.Test;


public class BowlingGameTest {

	@Test
	public void testconfigurationCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			@Override
			protected String getScannerInput() {
				return "3";
			}
		};
		gamee.runTimeScoreCal();  // configuration
	}

	@Test
	public void testInputCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "10", "10", "10", "10", "10", "10", "10", "10",
					"10", "10", "10", "10" };

			@Override
			protected String getScannerInput() {
				return array[++k];
			}
		};
		Assert.assertEquals(gamee.runTimeScoreCal(), 300);  // Expected as 300
	}

	@Test
	public void testInput1SuccessCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "10", "10", "10", "10", "10", "10", "10", "10",
					"10", "1", "1", "1" };
			@Override
			protected String getScannerInput() {
				return array[++k];
			}
		};
		Assert.assertEquals(gamee.runTimeScoreCal(), 245); // Expected as 245
	}

	@Test
	public void testInput2SuccessCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "9", "1", "10", "10", "10", "10", "10", "10",
					"10", "10", "10", "1", "1" }; // auto validate would trim ut the last data
			@Override
			protected String getScannerInput() {
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		Assert.assertEquals(gamee.runTimeScoreCal(), 263); // Expected as 263
	}

	@Test
	public void testInputAllZerosCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "0", "0", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };
			@Override
			protected String getScannerInput() {
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		Assert.assertEquals(gamee.runTimeScoreCal(), 0); // Expected as 0
	}

	@Test
	public void testInputMoreValuesProvidedThanExpectedCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "0", "0", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" }; 
			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		Assert.assertEquals(gamee.runTimeScoreCal(), 0); // Expected as 0
	}

	@Test
	public void testInputAutoValidationForWrongInputsCase2() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "9", "3", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" };
			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		Assert.assertEquals(gamee.runTimeScoreCal(), 10); // Expected as 10
	}
	
	@Test
	public void testconfigurationCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			@Override
			protected String getScannerInput() {
				return "3";
			}
		};
		gamee.startGameController();  // configuration
	}

	@Test
	public void testInputCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "10", "10", "10", "10", "10", "10", "10", "10",
					"10", "10", "10", "10" };

			@Override
			protected String getScannerInput() {
				return array[++k];
			}
		};
		gamee.getPinsDown();
		Assert.assertEquals(gamee.score(), 300);  // Expected as 300
	}

	@Test
	public void testInput1SuccessCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "10", "10", "10", "10", "10", "10", "10", "10",
					"10", "1", "1", "1" };
			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				return array[++k];
			}
		};
		gamee.getPinsDown();
		Assert.assertEquals(gamee.score(), 245); // Expected as 245
	}

	@Test
	public void testInput2SuccessCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "9", "1", "10", "10", "10", "10", "10", "10",
					"10", "10", "10", "1", "1" }; // auto validate would trim ut the last data
			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		gamee.getPinsDown();
		Assert.assertEquals(gamee.score(), 263); // Expected as 263
	}

	@Test
	public void testInputAllZerosCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "0", "0", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0" };

			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		gamee.getPinsDown();
		Assert.assertEquals(gamee.score(), 0); // Expected as 0
	}

	@Test
	public void testInputMoreValuesProvidedThanExpectedCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "0", "0", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" }; 
			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		gamee.getPinsDown();
		Assert.assertEquals(gamee.score(), 0); // Expected as 0
	}

	@Test
	public void testInputAutoValidationForWrongInputsCase1() {
		StartBowlingGame gamee = new StartBowlingGame(10) {
			int k = -1;
			String array[] = { "9", "3", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "1" };
			@Override
			protected String getScannerInput() {
				// TODO Auto-generated method stub
				try {
					return array[++k];
				} catch (ArrayIndexOutOfBoundsException ex) {
					return "0";
				}
			}
		};
		gamee.getPinsDown();
		Assert.assertEquals(gamee.score(), 10); // Expected as 10
	}

}
