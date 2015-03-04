echo 'cleaning..'
rm -f *.class
echo "compiling..."
javac -cp junit-4.10.jar *.java
if [ $? != 0 ] 
	then exit
fi
echo "running tests.."

echo "------------------ACCEPTANCE TEST--------------------------------"

echo "------------------Database TEST--------------------------------"

java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore DatabaseTest
echo $?

echo "------------------Library TEST--------------------------------"

java -cp ".;junit-4.10.jar" org.junit.runner.JUnitCore LibTest
echo $?

echo "--------------------- COMPLETED ---------------------------------"

rm -f *.class
