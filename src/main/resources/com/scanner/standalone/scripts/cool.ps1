
$processPath = Get-ChildItem -Path "C:\Program Files" -Filter $args[0]  -Recurse | Select-Object -ExpandProperty FullName  # Replace <ApplicationPath> with the actual path to the application

$process = Start-Process -PassThru -FilePath $processPath

$modules = $process | Get-Process | ForEach-Object {
    $processModules = @($_.Modules | Select-Object -Property FileName, ProductVersion)
    $processModules | Select-Object  FileName, ProductVersion
}

$modules | ConvertTo-Json |out-file '~\Desktop\Final-Year-Project\standalone\dependencies.json'

Start-Sleep -Seconds 0.5
$process | Stop-Process -Force