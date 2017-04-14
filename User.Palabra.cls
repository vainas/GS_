Class User.Palabra Extends %Persistent
{

Property Nombre As %String [ Required ];

Property arrayTraduccion As array Of %String;

Projection JavaPalabra As %Projection.Java;

Property DNI As %String;

Index DNIIndex On DNI [ Unique ];

Storage Default
{
<Data name="PalabraDefaultData">
<Value name="1">
<Value>%%CLASSNAME</Value>
</Value>
<Value name="2">
<Value>Nombre</Value>
</Value>
<Value name="3">
<Value>DNI</Value>
</Value>
</Data>
<Data name="arrayTraduccion">
<Attribute>arrayTraduccion</Attribute>
<Structure>subnode</Structure>
<Subscript>"arrayTraduccion"</Subscript>
</Data>
<DataLocation>^User.PalabraD</DataLocation>
<DefaultData>PalabraDefaultData</DefaultData>
<IdLocation>^User.PalabraD</IdLocation>
<IndexLocation>^User.PalabraI</IndexLocation>
<StreamLocation>^User.PalabraS</StreamLocation>
<Type>%Library.CacheStorage</Type>
}

}
