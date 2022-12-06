USE [GeoFIAP]
GO

/****** Object:  Table [dbo].[Place]    Script Date: 17/12/2019 20:40:32 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Place](
	[IDLocal] [bigint] NOT NULL,
	[Descricao] [varchar](100) NULL,
	[Observacao] [varchar](500) NULL,
	[CoordenadasGeo] [geography] NULL,
 CONSTRAINT [PK_Local] PRIMARY KEY CLUSTERED 
(
	[IDLocal] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


