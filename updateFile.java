BufferedReader file = new BufferedReader(new 
FileReader(updatingFileInfo.getFilePath()));
String line;
String input = "";
					
					
try {
			while ((line = file.readLine()) != null)
			  input += line + "\n";
} catch (IOException e) {
			e.printStackTrace();
}

input = input.replace(updatingFileInfo.getUpdatingLine(), updatingFileInfo.getUpdatedLine());
LOGGER.info(String.format("Replaced line %d", updatingFileInfo.getLineNumberInFile()));

FileOutputStream os = new FileOutputStream(updatingFileInfo.getFilePath());
os.write(input.getBytes());

file.close();
os.close();
