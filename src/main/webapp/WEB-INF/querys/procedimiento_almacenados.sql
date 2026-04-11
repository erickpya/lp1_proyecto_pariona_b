
USE BD_HR_LP1_B
GO

SELECT top 1 * from regions
go

sp_help regions
go

create or alter procedure usp_regions_guardar
@region_name varchar(25)
as
begin
	insert into regions(region_name) 
	values (@region_name)
end
go

create or alter procedure usp_regions_actualizar
@region_id int,
@region_name varchar(25)
as
begin
	update regions
		set region_name=@region_name
		where region_id=@region_id
end
go

create or alter procedure usp_regions_eliminar
@region_id int
as
begin
	delete from regions where region_id=@region_id
	--update regions set estado=0 where region_id=@region_id
end

alter table regions
add estado bit
go

update regions set estado=1 where region_id between 1 and 4
go

alter table regions
drop column fechaRegistro
go

alter table regions
drop column fechaActualizacion
go

alter table regions
drop constraint df_regions_fecreg
go

alter table regions
add fecha_registro datetime
go

alter table regions
add fecha_actualizacion datetime
go

alter table regions
add constraint df_regions_fecreg
default getdate() for fecha_registro
go

update regions set fecha_registro=GETDATE()
where region_id between 1 and 4
go

select * from regions
go

create or alter procedure usp_regions_consultar
as
begin
	select region_id, region_name from regions
end
go

create or alter procedure usp_regions_consultarXId
@region_id int
as
begin
	select region_id, region_name from regions
	where region_id= @region_id
end
go










