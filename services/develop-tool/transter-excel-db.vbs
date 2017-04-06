Option Explicit

Dim mdl ' the current model 
Set mdl = ActiveModel 
If (mdl Is Nothing) Then 
   MsgBox "There is no Active Model" 
End If
 
Dim HaveExcel 
Dim RQ 
RQ = vbYes 'MsgBox("Is Excel Installed on your machine ?", vbYesNo + vbInformation, "Confirmation") 
If RQ = vbYes Then 
  HaveExcel = True

  ' Open & Create Excel Document 
  Dim x1 ' 
  Set x1 = CreateObject("Excel.Application") 
  x1.Workbooks.Open "C:\Users\Administrator\workspace\moses\documents\design\merchants\merchant_contract.xlsx" 
  x1.Workbooks(1).Worksheets("Sheet1").Activate 
Else 
  HaveExcel = False 
End If

a x1, mdl

sub a(x1, mdl) 
dim rwIndex 
dim tableName 
dim colname 
dim table 
dim col 
dim count

'on error Resume Next 
For rwIndex = 1 To 66 step 1 
      With x1.Workbooks(1).Worksheets("Sheet1") 
      'MsgBox "生成数据表结构共计 1 ="+CStr(.Cells(2,2).Value ), vbOK + vbInformation, "表" 
      If .Cells(rwIndex, 1).Value = "" Then 
         Exit For 
      End If 
      If .Cells(rwIndex, 3).Value = "" Then 
         set table = mdl.Tables.CreateNew 
         table.Name = .Cells(rwIndex , 1).Value 
         table.Code = .Cells(rwIndex , 1).Value
         table.Comment = .Cells(rwIndex , 2).Value
         count = count + 1 
      Else 
         colName = .Cells(rwIndex, 1).Value 
         set col = table.Columns.CreateNew 
         'MsgBox .Cells(rwIndex, 1).Value, vbOK + vbInformation, "列" 
         col.Name = .Cells(rwIndex, 1).Value 
         'MsgBox col.Name, vbOK + vbInformation, "列" 
         col.Code = .Cells(rwIndex, 1).Value

         col.Comment = .Cells(rwIndex,2).Value 
         col.DataType = .Cells(rwIndex, 3).Value
         
      End If
      
      
       
   End With 
Next

MsgBox "生成数据表结构共计 " + CStr(count), vbOK + vbInformation, "表"

Exit Sub 
End sub
