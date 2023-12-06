import java.util.Scanner;
// Study Aid Program that offers math and physics formulas along with a unit converter and weighted grading tool
class Main {
  // Method to get integer input from user with prompt
  static int getInput(Scanner sc, String message) {
    // Print the provided message for the user
    System.out.print(message);
    // Variable created for user input
    int iValue = sc.nextInt();
    sc.nextLine(); 
    // Return the integer value entered by the user
    return iValue;
  }

  // Method to solve quadratic equation with user input
  static void solveQuadraticEquation(int valA, int valB, int valC) {
    // Determining the discriminant
    double dDeterminant= valB * valB - 4 * valA * valC;
    // Creating both of the root varibles
    double dRoot1, dRoot2;
    
    // In the case that the discriminant is greater than 0
    if (dDeterminant> 0) {
      dRoot1 = (-valB + Math.sqrt(dDeterminant)) / (2.0 * valA);
      dRoot2= (-valB - Math.sqrt(dDeterminant)) / (2.0 * valA);
    // Discriminat > 0 results in 2 different roots
      System.out.println("Two different roots exist.");
      System.out.println("Root 1 = " + dRoot1);
      System.out.println("Root 2 = " + dRoot2);
    // In the case that the discriminant is equal to 0
    } else if (dDeterminant== 0) {
      dRoot1 = dRoot2 = -valB / (2.0 * valA);
    // Discriminant = 0 results in 2 identical roots 
      System.out.println("Two identical roots exist.");
      System.out.println("Root 1 = Root 2 = " + dRoot1);
    } else {
    // In any other scenario, no real roots exist
      System.out.println("No real roots exist.");
    }
  }
  // Method to calculate hypotenuse of a right-angled triangle after being both of its "leg" values
  static double calculateHypotenuse(double side1, double side2) {
  // Performing the square root of both legs squared and added up in order to find the value of the hypotenuse
    return Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
  }
  // Method to calculate weighted grade from the user 
  static double calculateWeightedGrade(double[] scores, double[] weights) {
    // Checking to verify that the number of scores and weights are the same 
    if (scores.length != weights.length) {
      throw new IllegalArgumentException("Number of scores and weights must be the same.");
    }
    // Initializing both variables to contain scores and weights 
    double dTotalScore = 0.0;
    double dTotalWeight  = 0.0;

    // Calculate the weighted sum of scores
    for (int i = 0; i < scores.length; i++) {
    // Adding the scores to the total scores and multiplying it by the weights of those scores
      dTotalScore += scores[i] * weights[i];
    // Adding the weights to the total weights variable
      dTotalWeight  += weights[i];
    }

    // Calculating the final grade
    double dFinalGrade = dTotalScore / dTotalWeight ;
    // Returning the final grade
    return dFinalGrade;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  // While loop for user input to continue prompting until break statement
  while(true){
    // User input pertaining to options on what to do with study aid
    System.out.println();
    System.out.println("Welcome to Formula Guru ");
    System.out.println("What would you like to explore?");
    System.out.println("0) Quit");
    System.out.println("1) Math Formulas");
    System.out.println("2) Physics Formulas");
    System.out.println("3) Conversion Formulas");
    System.out.println("4) Weighted Grading Calculator ");
    // User input variable
    int iChoice = sc.nextInt();
    sc.nextLine(); 
    // User selected option 0: Quit program 
    if (iChoice == 0){
      // Print out exit message
      System.out.println("You have exited the program.");
      // Exit the while loop and end the program
      break;
      // User selected option 1: Math formulas 
      // Present user options pertaining to math formulas 
    } else if (iChoice == 1) {
      System.out.println("1) Solving a quadratic equation");
      System.out.println("2) Determining the hypotenuse");
      System.out.println("3) Determining compound interest");
      System.out.println("4) Area and circumference of a circle");
      System.out.println("5) Surface area and volume of a cuboid");
      System.out.println("6) Finding the distance between 2 points");
      // User input variable for math formulas options
      int iChoiceMathFormulas = sc.nextInt();
      sc.nextLine();

      if (iChoiceMathFormulas == 1) {
        // For option 1: Solving a quadratic equation
        // Utilizing the getInput method to receive user input
        int dValA = getInput(sc, "Enter the coefficient of x^2: ");
        int dValB = getInput(sc, "Enter the coefficient of x: ");
        int dValC = getInput(sc, "Enter the constant term: ");
        // Utilizing the solveQuadraticEquation method to apply the quadratic equation
        solveQuadraticEquation(dValA, dValB, dValC);
      } else if (iChoiceMathFormulas == 2) {
        // For option 2: Pythagorean theorem
        // Utilizing the getInput method to receive user input
        double side1 = getInput(sc, "Enter the length of side 1: ");
        double side2 = getInput(sc, "Enter the length of side 2: ");
        // Utilizing the calculateHypotenuse method to apply the pythaogorean theorum
        double dHypotenuse = calculateHypotenuse(side1, side2);
        // Printing out the hypotenuse value
        System.out.println("The hypotenuse is: " + dHypotenuse);
      } else if (iChoiceMathFormulas == 3) {
        // For option 3: Determining compound interest
        // Asking user to enter initial amount of money and storing it in a variable
        System.out.print("Enter the principal amount of money: ");
        double dPrincipal = sc.nextDouble();
        // Asking user to enter the interest rate and storing it in a variable
        System.out.print("Enter the interest rate as a %:  ");
        double dIntRt = sc.nextDouble();
        // Asking user to enter the period of time in years the interest would be collected and storing it in a variable
        System.out.print("Enter the period of time in years the interest will be collected: ");
        double dTime = sc.nextDouble();
        // Asking user to enter the compound amount of the interest and storing it in a variable
        System.out.print("Enter the number of times the interest compounds per year: ");
        double dComp = sc.nextDouble();
        // Dividing the interest rate by 100 to be used in the compound interest formula
        double dModIntRt = dIntRt / 100;
        // Performing the compound interest formula in stages (A = P(1+r/n)^nt)
        double dIntFormula1 = 1 + dModIntRt / dComp;
        double dIntFormula2 = Math.pow(dIntFormula1, dComp * dTime);
        double dIntFormula3 = dIntFormula2 * dPrincipal;
        // Rounding the final amount with compounding interest 
        String sRoundedIntFormula = String.format("%.2f", dIntFormula3);
        // Printing the rounded final amount 
        System.out.println("The amount with interest is $" + sRoundedIntFormula);
      } else if (iChoiceMathFormulas == 4) {
        // For option 4: Determining area and circumference of a circle
        // Asking user to enter the radius of the circle and storing it in a variable
        System.out.print("Enter the value of the radius: ");
        double dRad = sc.nextDouble();
        // Determing the area of the circle (A=pi*r^2)
        double dArea1 = Math.pow(dRad, 2);
        double dArea2 = Math.PI * dArea1;
        // Determining the circumference of a circle (C=2*pi*r)
        double dNum = 2.0;
        double dCircum1 = dRad * dNum;
        double dCircum2 = Math.PI * dCircum1;
        // Rounded the final circumeference and area values to 2 decimal places
        String sRoundedArea = String.format("%.2f", dArea2);
        String sRoundedCircumference = String.format("%.2f", dCircum2);
        // Printing the final values
        System.out
            .println("circumference = " + sRoundedCircumference + " units   area = " + sRoundedArea + " square units");
      } else if (iChoiceMathFormulas == 5) {
        // For option 5: Determining SFA and volume of a cuboid
        // Asking user to enter the height of the cuboid and storing it in a variable
        System.out.print("Enter the value of the height: ");
        double dHeight = sc.nextDouble();
        // Asking user to enter the width of the cuboid and storing it in a variable
        System.out.print("Enter the value of the width: ");
        double dWidth = sc.nextDouble();
        // Asking user to enter the length of the cuboid and storing it in a variable
        System.out.print("Enter the value of the length: ");
        double dLength = sc.nextDouble();
        // Determining the volume of the cuboid
        double dVolume = dHeight * dWidth * dHeight;
        // Determining the Surface Area of the cuboid
        double dSurfaceArea = 2 * ((dWidth * dLength) + (dWidth * dHeight) + (dLength * dHeight));
        // Rounding the final values of the volume and SFA of the cuboid
        String sRoundedVolume = String.format("%.2f", dVolume);
        String sRoundedSFA = String.format("%.2f", dSurfaceArea);
        // Printing the final rounded values of the volume and SFA of the cuboid
        System.out.println("The volume of the cuboid is " + sRoundedVolume + " cm^3");
        System.out.println("The surface area of the cuboid is " + sRoundedSFA + " cm^2");

      } else if (iChoiceMathFormulas == 6) {
        // For option 6: Finding the distance between two points
        // Asking user to enter the x value of the first pointing it in a variable
        System.out.print("Enter the x value of point 1: ");
        double dX1 = sc.nextDouble();
        // Asking user to enter the y value of the first point and storing it in a variable
        System.out.print("Enter the y value of point 1: ");
        double dY1 = sc.nextDouble();
        // Asking user to enter the x value of the second point and storing it in a variable
        System.out.print("Enter the x value of point 2: ");
        double dX2 = sc.nextDouble();
        // Asking user to enter the y value of the second point and storing it in a variable
        System.out.print("Enter the y value of point 2: ");
        double dY2 = sc.nextDouble();
        // Determing the distance between the x and y values of both points
        double dX = dX2 - dX1;
        double dY = dY2 - dY1;
        // Performing the pythagorean theorum to solve for the distance between both points
        double dDistance = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
        // Rounding the final answer to 2 decimal places
        String sRoundedDistance = String.format("%.2f", dDistance);
        // Printing the final answer
        System.out.println("The distance between both points is " + sRoundedDistance + " units");
      }
    } else if (iChoice == 2) {
      // User selected option 2: Physics formulas 
      // Present user options pertaining to physics formulas
      System.out.println("1) Solving a quadratic equation");
      System.out.println("2) 5 equations of motion");
      System.out.println("3) Calculating velocity ");
      System.out.println("4) Calculating acceleration ");
      System.out.println("5) Calculating work  ");
      System.out.println("6) Calculating kinetic energy ");
      System.out.println("7) Calculating gravitational potential energy ");
      System.out.println("8) Calculating power ");
      // User input variable for physics formulas options
      int iChoicePhysicsFormulas = sc.nextInt();
      sc.nextLine();

      if (iChoicePhysicsFormulas == 1) {
        // For option 1: Solving a quadratic equation
        // Utilizing the getInput method to receive user input
        int dValA = getInput(sc, "Enter the coefficient of x^2: ");
        int dValB = getInput(sc, "Enter the coefficient of x: ");
        int dValC = getInput(sc, "Enter the constant term: ");
         // Utilizing the solveQuadraticEquation method to apply the quadratic equation
        solveQuadraticEquation(dValA, dValB, dValC);
      }
      // For option 2: Solving the 5 equations of motion
      // Present user options pertaining to the 5 equations of motion 
      if (iChoicePhysicsFormulas == 2) {
        System.out.println("Which equation would you like to solve ");
        System.out.println("v = initial velocity, f = final velocity, d = displacement, t = time, a = acceleration ");
        System.out.println("1) d = ((v+f)/2)t ");
        System.out.println("2) f = v+at ");
        System.out.println("3) d = vt+0.5at^2 ");
        System.out.println("4) f^2 = v^2 + 2ad ");
        System.out.println("5) d = ft-0.5at^2 ");
        // User input variable for equations of motion options
        int iChoiceEquationsOfMotion = sc.nextInt();
        sc.nextLine();
        // User selected option 1: Equation 1
        if (iChoiceEquationsOfMotion == 1) {
          // Entering the initial velocity value and storing it in a variable 
          System.out.println("Enter the v value ");
          int iV1 = sc.nextInt();
          // Entering the final velocity value and storing it in a variable 
          System.out.println("Enter the f value ");
          int iF1 = sc.nextInt();
          // Entering the time value and storing it in a variable 
          System.out.println("Enter the t value ");
          int iT1 = sc.nextInt();
          // Performing the equation
          double dAnswer = ((iV1 + iF1) / 2) * iT1;
          // Rounding the final answer to 2 decimal places
          String sRoundedAnswer = String.format("%.2f", dAnswer);
          // Printing the final rounded answer
          System.out.println("The final answer is " + sRoundedAnswer + " m");

        }
        // User selected option 2: Equation 2
        else if (iChoiceEquationsOfMotion == 2) {
          // Entering the initial velocity value and storing it in a variable 
          System.out.println("Enter the v value ");
          int iV1 = sc.nextInt();
          // Entering the acceleration value and storing it in a variable 
          System.out.println("Enter the a value ");
          int iA1 = sc.nextInt();
          // Entering the time value and storing it in a variable 
          System.out.println("Enter the t value ");
          int iT1 = sc.nextInt();
          // Performing the equation
          double dAnswer = iV1 + iA1 * iT1;
          // Rounding the final answer 
          String sRoundedAnswer = String.format("%.2f", dAnswer);
          // Printing the final rounded answer
          System.out.println("The final answer is " + sRoundedAnswer+ " m/s");

        }
        // User selected option 3: Equation 3
        else if (iChoiceEquationsOfMotion == 3) {
          // Entering the initial velocity value and storing it in a variable
          System.out.println("Enter the v value ");
          int iV1 = sc.nextInt();
          // Entering the acceleration value and storing it in a variable
          System.out.println("Enter the a value ");
          int iA1 = sc.nextInt();
          // Entering the time value and storing it in a variable
          System.out.println("Enter the t value ");
          int iT1 = sc.nextInt();
          // Performing the equation in stages
          double dSquaredVal = Math.pow(iT1, 2);
          double dAnswer = iV1 * iT1 + 0.5 * iA1 * (dSquaredVal);
          // Rounding the final answer 
          String sRoundedAnswer = String.format("%.2f", dAnswer);
          // Printing the final rounded answer          
          System.out.println("The final answer is " + sRoundedAnswer+ " m");

        }
          // User selected option 4: Equation 4
        else if (iChoiceEquationsOfMotion == 4) {
          // Entering the initial velocity value and storing it in a variable
          System.out.println("Enter the v value ");
          int iV1 = sc.nextInt();
          // Entering the acceleration value and storing it in a variable
          System.out.println("Enter the a value ");
          int iA1 = sc.nextInt();
          // Entering the displacement velocity value and storing it in a variable
          System.out.println("Enter the d value ");
          int iD1 = sc.nextInt();
          // Performing the equation in stages       
          double dSqRtVal = Math.pow(iV1, 2);
          double dAnswer1 = dSqRtVal + 2 * iA1 * iD1;
          double dAnswer = Math.sqrt(dAnswer1);
          // Rounding the final answer 
          String sRoundedAnswer = String.format("%.2f", dAnswer);
          // Printing the final rounded answer          
          System.out.println("The final answer is " + sRoundedAnswer+ " m/s");

        }
        // User selected option 5: Equation 5
        else if (iChoiceEquationsOfMotion == 5) {
          // Entering the final velocity value and storing it in a variable
          System.out.println("Enter the f value ");
          int iV1 = sc.nextInt();
          // Entering the acceleration value and storing it in a variable
          System.out.println("Enter the a value ");
          int iA1 = sc.nextInt();
          // Entering the time value and storing it in a variable
          System.out.println("Enter the t value ");
          int iT1 = sc.nextInt();
          // Performing the equation in stages       
          double dSqRtVal = Math.pow(iT1, 2);
          double dAnswer = iV1 * iT1 - 0.5 * iA1 * dSqRtVal;
          // Rounding the final answer 
          String sRoundedAnswer = String.format("%.2f", dAnswer);
          // Printing the final rounded answer          
          System.out.println("Your final answer is " + sRoundedAnswer+ " m");

        }

      }
      // User selected option 3: Calculating velocity
      else if (iChoicePhysicsFormulas == 3) {
        // Entering the change in displacement and storing it in a variable
        System.out.println("Enter the change in displacement");
        int iChangeDisplacement = sc.nextInt();
        // Entering the change in time and storing it in a variable
        System.out.println("Enter the change in time in seconds ");
        int iChangeTime = sc.nextInt();
        // Performing the velocity formula       
        double dVelAnswer = iChangeDisplacement / iChangeTime;
        // Rounding the final answer
        String sRoundedVelAnswer = String.format("%.2f", dVelAnswer);
        // Printing the rounded final answer
        System.out.println("The velocity is " + sRoundedVelAnswer + " m/s");
      // User selection option 4: Calculating acceleration 
      
      } else if (iChoicePhysicsFormulas == 4) {
        // Entering the initial velocity value and storing it in a variable
        System.out.println("Enter the initial velocity value ");
        int iInitialVel = sc.nextInt();
        // Entering the final velocity value and storing it in a variable
        System.out.println("Enter the final velocity value ");
        int iFinalVel = sc.nextInt();
        // Entering the change in time and storing it in a variable
        System.out.println("Enter the change in time in seconds ");
        int iChangeTime = sc.nextInt();
        // Performing the acceleration formula
        double dAccAnswer = (iFinalVel - iInitialVel) / iChangeTime;
        // Rounding the final answer to 2 decimal places
        String sRoundedAccAnswer = String.format("%.2f", dAccAnswer);
        // Printing the final rounded answer
        System.out.println("The acceleration is " + sRoundedAccAnswer + " m/s^2");

      }
      // User selection option 5: Calculating work 
      else if (iChoicePhysicsFormulas == 5) {
        // Entering the force value and storing it in a variable
        System.out.println("Enter the value of the force being exerted in N");
        int iForceVal = sc.nextInt();
        // Entering the displacement value and storing it in a variable
        System.out.println("Enter the displacement value in m ");
        int iDisplaceVal = sc.nextInt();
        // Entering the angle value and storing it in a variable
        System.out.println("Enter the angle at which the force is being exerted to the displacement ");
        int iAngleVal = sc.nextInt();
        // Finding the cos of the angle 
        double dAngVal = Math.cos(Math.toRadians(iAngleVal));
        // Performing the work formula
        double dWorkVal = iForceVal * iDisplaceVal * dAngVal;
        // Rounding the final answer
        String sRoundedWorkValAnswer = String.format("%.2f", dWorkVal);
        // Printing the final rounded answer
        System.out.println("The work is " + sRoundedWorkValAnswer + " J");
        
      // User selected option 6: Calculating Kinetic energy
      } else if (iChoicePhysicsFormulas == 6) {
        // Entering the mass value and storing it in a variable
        System.out.println("Enter the mass of the object in kg ");
        int iMassVal = sc.nextInt();
        // Entering the velocity value and storing it in a variable
        System.out.println("Enter the velocity of the object in m/s ");
        int iVelVal = sc.nextInt();
        // Performing the kinetic energy formula
        double dKEVal = (Math.pow(iVelVal, 2)) * 0.5 * iMassVal;
        // Rounding the final answer
        String sRoundedKEValAnswer = String.format("%.2f", dKEVal);
        // Printing the final rounded answer
        System.out.println("The kinetic energy is " + sRoundedKEValAnswer + " J");
        
      // User selected option 7: Calculating gravitational potential energy 
      } else if (iChoicePhysicsFormulas == 7) {
        // Entering the mass value and storing it in a variable
        System.out.println("Enter the mass of the object in kg ");
        int iMassVal = sc.nextInt();
        // Entering the height value and storing it in a variable
        System.out.println("Enter the height in m ");
        int iHeightVal = sc.nextInt();
        // Creating a variable to store the acceleration due to gravity value
        double dAccDuetoGravity = 9.8;
        // Performing the GP energy formula
        double dGPEVal = iMassVal * dAccDuetoGravity * iHeightVal;
        // Rounding the final answer
        String sRoundedGPEValAnswer = String.format("%.2f", dGPEVal);
        // Printing the final rounded answer
        System.out.println("The kinetic energy is " + sRoundedGPEValAnswer + " J");

      }
      // User selected option 8: Calculating power
      else if (iChoicePhysicsFormulas == 8) {
        // Entering the change in energy and storing it in a variable
        System.out.println("Enter the change in energy in J ");
        int iEnergyVal = sc.nextInt();
        // Entering the change in time and storing it in a variable
        System.out.println("Enter the change in time in s ");
        int iTimeVal = sc.nextInt();
        // Performing the power formula
        double dPowerVal = iEnergyVal / iTimeVal;
        // Rounding the final answer
        String sRoundedPowerValAnswer = String.format("%.2f", dPowerVal);
        // Printing the final rounded answer
        System.out.println("The power is " + sRoundedPowerValAnswer + " W");

      }
      // User selected option 3: Conversion formulas
    } else if (iChoice == 3) {
      // Present user options pertaining to conversion formulas
      System.out.println("1) Temperature conversion ");
      System.out.println("2) Weight/Mass conversion ");
      System.out.println("3) Volume conversion ");
      System.out.println("4) Energy conversion ");
      System.out.println("5) Length conversion ");
      // User input variable for conversion formulas options
      int iChoiceConversionType = sc.nextInt();
      sc.nextLine();

      // User selected option 1: Temperature conversion 
      if (iChoiceConversionType == 1) {
        // Present user options pertaining to temperature conversion formulas
        System.out.println("What scale would you like to convert from?  ");
        System.out.println("1) Celsius ");
        System.out.println("2) Fahrenheit ");
        System.out.println("3) Kelvin ");
        // User input variable for temperature conversion formulas options
        int iChoiceTempConversion = sc.nextInt();
        sc.nextLine();
        // User input to enter value and storing it in a variable 
        System.out.println("What is the value? ");
        double iChoiceVal = sc.nextInt();
        sc.nextLine();

        // User selected option 1: Convert from celsius to Fahrenheit and Kelvin 
        if (iChoiceTempConversion == 1) {
          // Applying conversion formulas 
          double dFahrVal = (iChoiceVal * 9 / 5) + 32;
          double dKelVal = iChoiceVal + 273;
          // Rounding to 2 decimal units 
          String sRoundedFahrVal = String.format("%.2f", dFahrVal);
          String sRoundedKelVal = String.format("%.2f", dKelVal);
          // Printing final answer 
          System.out.println(iChoiceVal + " C = " + sRoundedFahrVal + " F  and " + sRoundedKelVal + " K ");
        // User selected option 2: Convert from Fahrenheit to Celsius and Kelvin
        } else if (iChoiceTempConversion == 2) {
          // Applying conversion formulas
          double dCelVal = (iChoiceVal - 32) * 5 / 9;
          double dKelVal = dCelVal + 273;
          // Rounding to 2 decimal units 
          String sRoundedCelVal = String.format("%.2f", dCelVal);
          String sRoundedKelVal = String.format("%.2f", dKelVal);
          // Printing final answer
          System.out.println(iChoiceVal + " F = " + sRoundedCelVal + " C  and " + sRoundedKelVal + " K ");
        }
        // User selected option 3: Convert from Kelvin to Celsius and Fahrenheit
        else if (iChoiceTempConversion == 3) {
          // Applying conversion formulas
          double dCelVal = iChoiceVal - 273;
          double dFahrVal = (dCelVal * 9 / 5) + 32;
          // Rounding to 2 decimal units 
          String sRoundedCelVal = String.format("%.2f", dCelVal);
          String sRoundedFahrVal = String.format("%.2f", dFahrVal);
          // Printing final answer
          System.out.println(iChoiceVal + " K = " + sRoundedCelVal + " C  and " + sRoundedFahrVal + " F ");
        }
        // User selected option 2: Weight/Mass conversion 
        else if (iChoiceConversionType == 2) {
          // Present user options pertaining to weight/mass conversion formulas
          System.out.println("What unit would you like to convert from?  ");
          System.out.println("1) Kg ");
          System.out.println("2) Lbs ");
          System.out.println("3) Ounces ");
          // User input variable for weight/mass conversion formulas options
          int iChoiceWeightConversion = sc.nextInt();
          sc.nextLine();
          // User input to enter value and storing it in a variable 
          System.out.println("What is the value? ");
          double iChoiceVal1 = sc.nextInt();
          sc.nextLine();
          // User selected option 1: Convert from kg to lbs and oz
          if (iChoiceWeightConversion == 1) {
            // Applying conversion formulas
            double dLbsVal = iChoiceVal1 * 2.2;
            double dOzVal = iChoiceVal1 * 35.27;
            // Rounding to 2 decimal units 
            String sRoundedLbsVal = String.format("%.2f", dLbsVal);
            String sRoundedOzVal = String.format("%.2f", dOzVal);
            // printing the final answer
            System.out.println(iChoiceVal1 + " kg = " + sRoundedLbsVal + " lbs  and " + sRoundedOzVal + " oz ");
          // User selected option 2: Convert from lbs to kg and oz
          } else if (iChoiceWeightConversion == 2) {
            // Applying conversion formulas
            double dKgVal = iChoiceVal1 * 0.45;
            double dOzVal = iChoiceVal1 * 16;
            // Rounding to 2 decimal units 
            String sRoundedKgVal = String.format("%.2f", dKgVal);
            String sRoundedOzVal = String.format("%.2f", dOzVal);
            // printing the final answer
            System.out.println(iChoiceVal1 + " lbs = " + sRoundedKgVal + " kg  and " + sRoundedOzVal + " oz ");
          }
          // User selected option 3: Convert from oz to lbs and kg
          else if (iChoiceWeightConversion == 3) {
            // Applying conversion formulas
            double dKgVal = iChoiceVal1 * 0.028;
            double dLbsVal = iChoiceVal1 * 0.0625;
            // Rounding to 2 decimal units 
            String sRoundedKgVal = String.format("%.2f", dKgVal);
            String sRoundedLbsVal = String.format("%.2f", dLbsVal);
            // printing the final answer
            System.out.println(iChoiceVal1 + " oz = " + sRoundedKgVal + " kg  and " + sRoundedLbsVal + " lbs ");
          }

        }
      // User selected option 1: Volume conversion
      } else if (iChoiceConversionType == 3) {
        // Present user options pertaining to volume conversion formulas
        System.out.println("What unit would you like to convert from?  ");
        System.out.println("1) Liters ");
        System.out.println("2) US Gallon ");
        System.out.println("3) Quarts ");
        // User input variable for volume conversion formulas options
        int iChoiceVolumeConversion = sc.nextInt();
        sc.nextLine();
        // User input to enter value and storing it in a variable 
        System.out.println("What is the value? ");
        int iChoiceVal = sc.nextInt();
        sc.nextLine();
        // User selected option 1: Convert from L to gal and qt 
        if (iChoiceVolumeConversion == 1) {
          // Applying conversion formulas
          double dUSGVal = iChoiceVal * 0.264;
          double dQuartVal = iChoiceVal * 1.057;
          // Rounding to 2 decimal units 
          String sRoundedUSGVal = String.format("%.2f", dUSGVal);
          String sRoundedQuartVal = String.format("%.2f", dQuartVal);
          // Printing final answer
          System.out.println(iChoiceVal + " L = " + sRoundedUSGVal + " gal  and " + sRoundedQuartVal + " qt ");
        // User selected option 2: Convert from gal to gal and L 
        } else if (iChoiceVolumeConversion == 2) {
          // Applying conversion formulas
          double dLVal = iChoiceVal * 3.79;
          double dQuartVal = iChoiceVal * 4;
          // Rounding to 2 decimal units 
          String sRoundedLVal = String.format("%.2f", dLVal);
          String sRoundedQuartVal = String.format("%.2f", dQuartVal);
          // Printing final answer
          System.out.println(iChoiceVal + " gal = " + sRoundedLVal + " L  and " + sRoundedQuartVal + " qt ");
        }
        // User selected option 3: Convert from qt to gal and L 
        else if (iChoiceVolumeConversion == 3) {
          // Applying conversion formulas
          double dLVal = iChoiceVal * 0.946;
          double dUSGVal = iChoiceVal * 0.25;
          // Rounding to 2 decimal units 
          String sRoundedLVal = String.format("%.2f", dLVal);
          String sRoundedUSGVal = String.format("%.2f", dUSGVal);
          // Printing final answer
          System.out.println(iChoiceVal + " qt = " + sRoundedLVal + " L  and " + sRoundedUSGVal + " gal ");
        }
       // User selected option 4: Energy conversion
      } else if (iChoiceConversionType == 4) {
        // Present user options pertaining to energy conversion formulas
        System.out.println("What unit would you like to convert from?  ");
        System.out.println("1) Joules ");
        System.out.println("2) Calories ");
        // User input variable for energy conversion formulas options
        int iChoiceEnergyConversion = sc.nextInt();
        sc.nextLine();
        // User input to enter value and storing it in a variable
        System.out.println("What is the value? ");
        int iChoiceVal = sc.nextInt();
        sc.nextLine();
        // User selected option 1: Convert from J to C
        if (iChoiceEnergyConversion == 1) {
          // Applying conversion formula 
          double dCalVal = iChoiceVal * 0.239;
          // Rounding to 2 decimal units 
          String sRoundedCalVal = String.format("%.2f", dCalVal);
          // Printing final answer
          System.out.println(iChoiceVal + " J = " + sRoundedCalVal + " cal");
        // User selected option 2: Convert from C to J
        } else if (iChoiceEnergyConversion == 2) {
          // Applying conversion formula 
          double dJouleVal = iChoiceVal * 4.184;
          // Rounding to 2 decimal units 
          String sRoundedJouleVal = String.format("%.2f", dJouleVal);
          // Printing final answer
          System.out.println(iChoiceVal + " cal = " + sRoundedJouleVal + " J");
        }
      // User selected option 5: Length conversion
      } else if (iChoiceConversionType == 5) {
        // Present user options pertaining to length conversion formulas
        System.out.println("What unit would you like to convert from?  ");
        System.out.println("1) km ");
        System.out.println("2) miles ");
        System.out.println("3) yards ");
        // User input variable for length conversion formulas options
        int iChoiceLengthConversion = sc.nextInt();
        sc.nextLine();
        // User input to enter value and storing it in a variable 
        System.out.println("What is the value? ");
        int iChoiceVal = sc.nextInt();
        sc.nextLine();
        // User selected option 1: Convert from km to mil and yd 
        if (iChoiceLengthConversion == 1) {
           // Applying conversion formulas
          double dMilVal = iChoiceVal * 0.621;
          double dYrdVal = iChoiceVal * 1093.6;
          // Rounding to 2 decimal units 
          String sRoundedMilVal = String.format("%.2f", dMilVal);
          String sRoundedYrdVal = String.format("%.2f", dYrdVal);
          // Printing final answer
          System.out.print(iChoiceVal + " km = " + sRoundedMilVal + " mi  and " + sRoundedYrdVal + " yd ");
        // User selected option 2: Convert from mil to yd and km 
        } else if (iChoiceLengthConversion == 2) {
           // Applying conversion formulas
          double dKmVal = iChoiceVal * 1.61;
          double dYrdVal = iChoiceVal * 1760;
          // Rounding to 2 decimal units 
          String sRoundedKmVal = String.format("%.2f", dKmVal);
          String sRoundedYrdVal = String.format("%.2f", dYrdVal);
          // Printing final answer
          System.out.print(iChoiceVal + " mi = " + sRoundedKmVal + " km  and " + sRoundedYrdVal + " yd ");
        // User selected option 3: Convert from yd to mil and km 
        } else if (iChoiceLengthConversion == 3) {
           // Applying conversion formulas
          double dKmVal = iChoiceVal * 0.0009144;
          double dMilVal = iChoiceVal * 0.000568;
          // Rounding to 2 decimal units 
          String sRoundedKmVal = String.format("%.2f", dKmVal);
          String sRoundedMilVal = String.format("%.2f", dMilVal);
          // Printing final answer
          System.out.print(iChoiceVal + " yd = " + sRoundedKmVal + " km  and " + sRoundedMilVal + " mi ");
        }
      }
    // User selected option 4: Weighted Grading Calculator
    } else if (iChoice == 4) {
        // User input for number of grades to enter and storing it in a variable
        System.out.println("How many grades would you like to enter? ");
        int iNumGrades = sc.nextInt();
        sc.nextLine();
        // Creating arrays for scores and weights with length from iNumGrades variable
        double[] sGradeScores = new double[iNumGrades];
        double[] sGradeWeights = new double[iNumGrades];
        // for loop that asks for your grades for the number of grades you wanted to enter
        for (int i = 0; i < iNumGrades; i++) {
            // Try case asking user to enter their grade and storing it in a variable
            try {
                System.out.println("Enter grade " + (i + 1));
                sGradeScores[i] = sc.nextDouble();

                // Making sure grade scores are above 0
                if (sGradeScores[i] <= 0) {
                    throw new IllegalArgumentException("Scores must be greater than 0");
                }
              // Catch case if grades are less than 1
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; 
            }
        }
          
          // User input asking for grade weight and storing it in a variable
          // Loop for entering grade weights
        for (int i = 0; i < iNumGrades; i++) {
            // Try case
            try {
                System.out.println("Enter the weight for grade " + (i + 1));
                sGradeWeights[i] = sc.nextDouble();

                // Making sure grade weights are above 0
                if (sGradeWeights[i] <= 0) {
                    throw new IllegalArgumentException("Weights must be greater than 0");
                }
              // Catch case for if grades aren't above 0
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; 
            }
        }
        // Applying the calculateWeightedGrade method to find final grade
        double dFinalGrade = calculateWeightedGrade(sGradeScores, sGradeWeights);
        // Rounding to 2 decimal units
        String sRoundedFinalGrade = String.format("%.2f", dFinalGrade);
        // Printing final grade
        System.out.println("Your final grade is " + sRoundedFinalGrade);
    // else statement to deal with invalid input
    } else {
      System.out.println("Invalid choice. Please select a valid option.");
    }

  }
  }
}
